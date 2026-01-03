package Graph;

import java.util.ArrayList;

public class DFS {

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean Visited[]) {  // O(V + E)
        Visited[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0 ; i < graph[curr].size() ; i++ ) {
            if (!Visited[graph[curr].get(i).des]) {
                dfs(graph, graph[curr].get(i).des, Visited);
            }
        }
    } 

    public static void main(String[] args) {
        // Graph

        //      1 ----- 3
        //    /         |  \
        //  0           |    5 ---- 6
        //    \         |  /
        //      1 ----- 3

        int V = 7;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();  // Initialize with empty Arraylist
        }

        // All Edges of vertex 0
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        // All Edges of vertex 1
        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 3));

        // All Edges of vertex 2
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        // All Edges of vertex 3
        graph[3].add(new Edge(3, 1));
        graph[3].add(new Edge(3, 4));
        graph[3].add(new Edge(3, 5));

        // All Edges of vertex 4
        graph[4].add(new Edge(4, 2));
        graph[4].add(new Edge(4, 3));
        graph[4].add(new Edge(4, 5));

        // All Edges of vertex 5
        graph[5].add(new Edge(5, 3));
        graph[5].add(new Edge(5, 4));
        graph[5].add(new Edge(5, 6));

        // All Edges of vertex 6
        graph[6].add(new Edge(6, 5));

        boolean Visited[] = new boolean[V];

        // Graph Travelling
        System.out.print("Graph Node After DFS: ");
        dfs(graph, 0 ,  Visited);
    }
}
