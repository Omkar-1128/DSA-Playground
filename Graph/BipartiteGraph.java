package Graph;

import java.util.*;;

public class BipartiteGraph {

    static class Edge {
        int src;
        int des;

        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }

    // O(V + E)
    public static boolean bfs(ArrayList<Edge>[] graph) {
        int color[] = new int[graph.length];
        for (int i = 0; i < color.length; i++) {
            color[i] = -1;
        }

        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                if (!bfsUtil(graph, color, i)) {
                    return false;
                }
            }
        }

        return false;
    }

    public static boolean bfsUtil(ArrayList<Edge>[] graph, int[] color, int src) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.remove();

            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);

                if (color[e.des] == color[curr]) {
                    return false;
                } else if (color[e.des] == -1) {
                    if (color[curr] == 0) {
                        color[e.des] = 1;
                    } else {
                        color[e.des] = 0;
                    }

                    q.add(e.des);
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // Bipartite Graph
        // It is a graph in which the vertices can be divided into two disjoint sets
        // such that no two vertices in the same set are connected by an edge

        // If the Graph Doesn't Have a cycle then the Graph is always Bipartite Graph

        //               0
        //              / \
        //             /   \
        //            1     2    // Not biPartite Graph
        //            |     |
        //            |     |
        //            3 --- 4

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));

        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 2));

        graph[2].add(new Edge(2, 4));
        graph[2].add(new Edge(2, 0));

        if (bfs(graph)) {
            System.out.println("Graph is Bipartite");
        } else {
            System.out.println("Graph is Not Bipartite");
        }
    }
}
