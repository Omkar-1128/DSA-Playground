package Graph;
import java.util.*;

public class BFS {

    static class Edge {
        int src;
        int des;

        public Edge(int s , int d) {
            this.src = s;
            this.des = d;
        }
    }

    public static void bfs(ArrayList<Edge>[] graph , int V) {   // O(V + E)
        Queue<Integer> q = new LinkedList<>();
        q.add(0);   // source = 0
        boolean visited[] = new boolean[V];

        while (!q.isEmpty()) {
            int curr = q.remove();  // 0

            if(!visited[curr]) {
                visited[curr] = true;   // Visit Current
                System.out.print(curr + " ");
                for(int i = 0 ; i < graph[curr].size() ; i++) {
                    q.add(graph[curr].get(i).des);
                }
            }
        }
    }

    public static void main(String[] args) {
        // Graph

        //      1 ----- 3
        //    /         |  \
        //  0           |    5 ---- 6
        //    \         |  /
        //      2 ----- 4

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


        // Graph Travelling
        System.out.print("Graph Node After BFS: ");
        bfs(graph, V);
    }
}
