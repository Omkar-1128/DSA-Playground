package Graph2;

import java.util.*;

// Connecting Cities with minimum Cost
public class PQ {
    // Use Prims Algorithm to calculate the minimum cost for connecting cities

    static class Pair implements Comparable<Pair> {
        int node;
        int dist;

        public Pair(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pair o) {
            return this.dist - o.dist;
        }
    }

    public static void mst(int[][] cities) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));

        int minCost = 0;
        boolean visited[] = new boolean[cities.length];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            if (!visited[curr.node]) {
                visited[curr.node] = true;
                minCost += curr.dist;

                for (int i = 0; i < cities[curr.node].length; i++) {
                    if (!visited[i] && cities[curr.node][i] != 0) {
                        pq.add(new Pair(i, cities[curr.node][i]));
                    }
                }
            }
        }

        System.out.println("Minimum cost to connect all the cities: " + minCost);
    }

    public static void main(String[] args) {
        int[][] cities = {
                { 0, 1, 2, 3, 4 },
                { 1, 0, 5, 0, 7 },
                { 2, 5, 0, 6, 0 },
                { 3, 0, 6, 0, 0 },
                { 4, 7, 0, 0, 0 }
        };

        mst(cities);
    }
}

// Important Problem // Alien Dictionary

// We are given a list of words from an alien language that are already sorted according to the rules of that language. The alien language uses English letters, but the order of these letters is unknown. Our task is to determine the correct order of the characters in the alien language.

// To find this order, we compare adjacent words and identify the first position where the characters differ. The character from the first word must appear before the character from the second word in the alien language. These relations form a directed graph, and topological sorting is used to find a valid character order.

// If a longer word appears before its own prefix, or if a cycle exists in the character graph, no valid order is possible and an empty string is returned. Otherwise, any valid character order may be returned.

// class Solution {

//     public String findOrder(String[] words) {
//         // code here

//         HashMap<Character, Integer> Indegree = new HashMap<>(); // To store the indegree of each character(node)
//         HashMap<Character, ArrayList<Character>> map = new HashMap<>(); // Graph of character in which each list element
//                                                                         // is destination of edge

//         for (int i = 0; i < words.length; i++) {
//             for (int j = 0; j < words[i].length(); j++) {
//                 char ch = words[i].charAt(j);
//                 Indegree.putIfAbsent(ch, 0); // initializing all the character in the words array with indegree 0
//             }
//         }

//         outer: for (int i = 0; i < words.length - 1; i++) {
//             int n1 = words[i].length();
//             int n2 = words[i + 1].length();

//             int n = Math.min(n1, n2);

//             for (int j = 0; j < n; j++) { // comparing two letters
//                 char c1 = words[i].charAt(j);
//                 char c2 = words[i + 1].charAt(j);

//                 // If characters are not equal then add in graph(map) with edge c1 ---> c2
//                 // c1 comes before c2
//                 if (c1 != c2) {
//                     map.computeIfAbsent(c1, k -> new ArrayList<>());
//                     if (!map.get(c1).contains(c2)) {
//                         map.get(c1).add(c2);
//                         Indegree.put(c2, Indegree.get(c2) + 1); // Increase the indegree of c2
//                     }
//                     continue outer;
//                 }
//             }

//             if (n1 > n2)
//                 return ""; // Prefix condition (e.d "abc" , "abcd" -> invalid) No any unique character
//         }

//         // Topologocal Sorting // Kahn's Algotithm

//         Queue<Character> q = new LinkedList<>();
//         StringBuilder ans = new StringBuilder("");

//         // Initializing queue with character of Zero indegree
//         for (Character ch : Indegree.keySet()) {
//             if (Indegree.get(ch) == 0) {
//                 q.add(ch);
//             }
//         }

//         while (!q.isEmpty()) {
//             char curr = q.remove();
//             ans.append(curr);

//             // check all the neighbours of curr reduce the indegree of all the neighbour of
//             // curr
//             // then check their indegree becomes zero if zero then add in queue
//             if (map.containsKey(curr)) {
//                 for (int i = 0; i < map.get(curr).size(); i++) {
//                     char des = map.get(curr).get(i);
//                     Indegree.put(des, Indegree.get(des) - 1);

//                     if (Indegree.get(des) == 0) {
//                         q.add(des);
//                     }
//                 }
//             }
//         }

//         // ans should contain all the letters of the dictonary words
//         // Indegree contains all the letters
//         if (ans.length() != Indegree.size()) {
//             return "";
//         }

//         return ans.toString();
//     }
// }

// leetcode
// 787. Cheapest Flights Within K Stops

// Using dijkstra
// class Solution {
// static class Edge {
// int src;
// int des;
// int wt;

// public Edge(int src, int des, int wt) {
// this.src = src;
// this.des = des;
// this.wt = wt;
// }
// }

// static class Info {
// int node;
// int path;
// int stops;

// public Info(int node, int path, int stops) {
// this.node = node;
// this.path = path;
// this.stops = stops;
// }
// }

// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// ArrayList<Edge>[] graph = new ArrayList[n];

// for (int i = 0; i < n; i++) {
// graph[i] = new ArrayList<>();
// }

// for (int i = 0; i < flights.length; i++) {
// graph[flights[i][0]].add(new Edge(flights[i][0], flights[i][1],
// flights[i][2]));
// }

// Queue<Info> q = new LinkedList<>();
// q.add(new Info(src, 0, 0));
// int distance[] = new int[n];

// for (int i = 0; i < n; i++) {
// if (i != src) {
// distance[i] = Integer.MAX_VALUE;
// }
// }

// while (!q.isEmpty()) {
// Info curr = q.remove();
// int currNode = curr.node;
// int currStops = curr.stops;
// if(currStops > k) {
// break;
// }

// for (int i = 0; i < graph[currNode].size(); i++) {
// int u = currNode;
// int v = graph[currNode].get(i).des;
// int wt = graph[currNode].get(i).wt;

// if (distance[u] != Integer.MAX_VALUE && curr.path + wt < distance[v] &&
// currStops <= k) {
// distance[v] = curr.path + wt;
// q.add(new Info(v, distance[v], currStops + 1));
// }
// }
// }

// if (distance[dst] != Integer.MAX_VALUE) {
// return distance[dst];
// }

// return -1;
// }
// }

// Using Bellman

// class Solution {
// public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k)
// {
// int distance[] = new int[n];

// for (int i = 0; i < n; i++) {
// if (i != src) {
// distance[i] = Integer.MAX_VALUE;
// }
// }

// for (int i = 0; i <= k; i++) { // relax k + 1 times

// int temp[] = new int[n];
// for(int j = 0 ; j < n ; j++) {
// temp[j] = distance[j];
// }

// for(int j = 0 ; j < flights.length ; j++) {
// int u = flights[j][0];
// int v = flights[j][1];
// int wt = flights[j][2];

// if(distance[u] != Integer.MAX_VALUE && distance[u] + wt < temp[v]) {
// temp[v] = distance[u] + wt;
// }
// }

// distance = temp;
// }

// if (distance[dst] != Integer.MAX_VALUE) {
// return distance[dst];
// }

// return -1;
// }
// }