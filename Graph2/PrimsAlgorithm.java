package Graph2;

import java.util.*;

public class PrimsAlgorithm {

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

    static class Info implements Comparable<Info> {
        int parent;
        int node;
        int dist;

        public Info(int parent, int node, int dist) {
            this.parent = parent;
            this.node = node;
            this.dist = dist;
        }

        @Override
        public int compareTo(Info o) {
            return this.dist - o.dist;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1, 10));
        graph[0].add(new Edge(0, 3, 30));
        graph[0].add(new Edge(0, 2, 15));

        graph[1].add(new Edge(1, 0, 10));
        graph[1].add(new Edge(1, 3, 40));

        graph[3].add(new Edge(3, 1, 40));
        graph[3].add(new Edge(3, 0, 30));
        graph[3].add(new Edge(3, 2, 50));

        graph[2].add(new Edge(2, 3, 50));
        graph[2].add(new Edge(2, 0, 15));
    }

    // Prims Algorithm to get MST(Minimim Spanning tree)
    public static void PrimsAlgo(ArrayList<Edge>[] graph, int src) {
        ArrayList<Edge> mst = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue<>();
        pq.add(new Info(src, src, 0));

        boolean[] visited = new boolean[graph.length];
        while (!pq.isEmpty()) {
            Info currInfo = pq.remove();
            if (!visited[currInfo.node]) {
                visited[currInfo.node] = true;
                mst.add(new Edge(currInfo.parent, currInfo.node, currInfo.dist));

                for (int i = 0; i < graph[currInfo.node].size(); i++) {
                    Edge e = graph[currInfo.node].get(i);

                    if (!visited[e.des]) {
                        pq.add(new Info(currInfo.node, e.des, e.wt));
                    }
                }
            }
        }

        // Print 
        int weight = 0;
        System.out.println("src" + "\t" + "dest" + "\t" + "distance");
        for (int i = 0; i < mst.size(); i++) {
            Edge e = mst.get(i);
            System.out.println(e.src + "\t" + e.des + "\t" + e.wt);
            weight += e.wt;
        }

        System.out.println("MST Weight: " + weight);

    }

    public static void main(String[] args) {
        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < V; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);

        PrimsAlgo(graph, 0);

    }
}
