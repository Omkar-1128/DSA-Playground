package Graph;

import java.util.*;

public class ConnectedGraph {

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    // BFS (Breath First Search)
    public static void bfs(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];

        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                bfsUtil(graph, i, visited);
            }
        }
    } 
    
    // Healper Function
    public static void bfsUtil(ArrayList<Edge>[] graph, int source , boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(source);

        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!visited[curr]) {
                visited[curr] = true;
                System.out.print(curr + " ");

                for (int i = 0; i < graph[curr].size(); i++) {
                    q.add(graph[curr].get(i).des);
                }
            }
        }
    }

    // DFS (Deapth First Search)
    public static void dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                dfsUtil(graph, i, visited);
            }
        }
    }

    public static void dfsUtil(ArrayList<Edge>[] graph , int source , boolean[] visited) {
        visited[source] = true;
        System.out.print(source + " ");

        for(int i = 0 ; i < graph[source].size() ; i++) {
            if(!visited[graph[source].get(i).des]) {
                dfsUtil(graph, graph[source].get(i).des, visited);
            }
        }
    }

    public static void main(String[] args) {
        // Graph
        // 0
        // / \ 4 ---- 5
        // / \ |
        // 1 2 |
        // \ 6
        // \
        // 3

        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 3));
        graph[2].add(new Edge(2, 0));
        graph[3].add(new Edge(3, 2));
        graph[4].add(new Edge(4, 5));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));
        graph[6].add(new Edge(6, 5));

        // BFS For Disconneted Graph
        System.out.print("BFS Graph: ");
        bfs(graph);

        System.out.println();

        System.out.print("DFS Graph: ");
        dfs(graph);

    }
}
