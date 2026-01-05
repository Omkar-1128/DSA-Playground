package Graph2;

import java.util.*;

public class BellmanFord {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void bellmanFord(ArrayList<Edge> graph, int src, int V) { // O(V * E)
        int distance[] = new int[V];

        for (int i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Algorithm
        for (int i = 0; i < V - 1; i++) {
            // O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);

                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                // Relaxation
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Print
        for (int i = 0; i < distance.length; i++) {
            System.out.println(src + " -> " + i + " : " + distance[i]);
        }
    }

    public static void DetectNegativeCycle(ArrayList<Edge> graph, int src, int V) {
        int distance[] = new int[V];
        boolean cycle = false;

        for (int i = 0; i < distance.length; i++) {
            if (i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Algorithm
        for (int i = 0; i < V - 1; i++) {
            // O(E)
            for (int j = 0; j < graph.size(); j++) {
                Edge e = graph.get(j);

                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                // Relaxation
                if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        for (int j = 0; j < graph.size(); j++) {
            Edge e = graph.get(j);

            int u = e.src;
            int v = e.des;
            int wt = e.wt;

            // Relaxation
            if (distance[u] != Integer.MAX_VALUE && distance[u] + wt < distance[v]) {
                cycle = true;
            }
        }

        if(cycle) {
            System.out.println("Negative cycle Exist in the graph");
        } else {
            System.out.println("Negative cycle does not Exits in the graph");
        }
    }

    public static void CreateGraph(ArrayList<Edge> graph) {
        graph.add(new Edge(0, 1, 2));
        graph.add(new Edge(0, 2, 4));
        graph.add(new Edge(1, 2, -4));
        graph.add(new Edge(2, 3, 2));
        graph.add(new Edge(3, 4, 4));
        graph.add(new Edge(4, 1, -1));
    }

    public static void main(String[] args) {
        int V = 5;
        ArrayList<Edge> graph = new ArrayList<>();

        CreateGraph(graph);

        bellmanFord(graph, 0, V);
        DetectNegativeCycle(graph, 0, V);
    }
}
