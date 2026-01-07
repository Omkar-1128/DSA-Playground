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

                for (int i = 0; i < cities[curr.node].length ; i++) {
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