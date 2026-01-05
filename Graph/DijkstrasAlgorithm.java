package Graph;
import java.util.*;

public class DijkstrasAlgorithm {

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src, int des , int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    static class Pair implements Comparable <Pair> {   // Soting Happens Based On Path
        int n;
        int path;

        public Pair(int n , int path) {
            this.n = n;
            this.path = path;
        }

        @Override
        public int compareTo(Pair o) {   
            return this.path - o.path;
        }
    }

    public static void dijkstra(ArrayList<Edge>[] graph , int src) {
        // Make distance array
        int distance[] = new int[graph.length];
        // Initialize all distance except src with Infinite
        for(int i = 0 ; i < graph.length ; i++) {
            if(i != src) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        // Make Priority Queue For Pair So we get Sorted path node first
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, 0));

        boolean[] visited = new boolean[graph.length];

        while (!pq.isEmpty()) {
            Pair curr = pq.remove();
            visited[curr.n] = true;

            for(int i = 0 ; i < graph[curr.n].size() ; i++) {
                Edge e = graph[curr.n].get(i);

                int u = e.src;
                int v = e.des;
                int wt = e.wt;

                // Main Formula
                if(distance[u] + wt < distance[v]) {
                    distance[v] = distance[u] + wt;
                    pq.add(new Pair(v, distance[v]));
                }
            }
        }

        // Print The Sortest Path
        for(int i = 0 ; i < graph.length ; i++) {
            System.out.println(src + " -> " + i + " = " + distance[i]);
        }
    }
    
    public static void main(String[] args) {
        // Graph
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1, 2));
        graph[0].add(new Edge(0, 2, 4));

        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 7));

        graph[2].add(new Edge(2, 4, 3));

        graph[3].add(new Edge(3, 5, 1));

        graph[4].add(new Edge(4, 3, 2));
        graph[4].add(new Edge(4, 5, 5));

        dijkstra(graph, 0);
    }
}
