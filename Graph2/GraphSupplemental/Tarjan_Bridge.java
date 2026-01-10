package Graph2.GraphSupplemental;
import java.util.*;

// Tarjans Algorithm used to get the node that creates a bridge
// TC :- O(V + E)
public class Tarjan_Bridge {

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 1));

        graph[3].add(new Edge(3, 0));
        graph[3].add(new Edge(3, 4));
        // graph[3].add(new Edge(3, 5));

        graph[4].add(new Edge(4, 3));
        // graph[4].add(new Edge(4, 5));

        // graph[5].add(new Edge(5, 3));
        // graph[5].add(new Edge(5, 4));
    }

    // Tarjan's Algorithm
    static int time = 0;
    public static void Tarjan(ArrayList<Edge>[] graph, int curr , int parent , int[] dt , int[] low , boolean[] visited) {
        visited[curr] = true;
        dt[curr] = low[curr] = ++time;

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            // If neighbour are not visited
            // visite -> update lowest discovery time -> if bridge present print the bridge
            if(!visited[e.des]) {
                Tarjan(graph , e.des , curr , dt , low , visited);
                low[curr] = Math.min(low[curr] , low[e.des]);

                if(dt[curr] < low[e.des]) {
                    System.out.println(curr + " --> " + e.des);
                }

            } else if(visited[e.des] && e.des != parent) {  // Neighbour is visited and not parent // Just update low
                low[curr] = Math.min(low[curr], dt[e.des]);
            }

            // Do nothing if the neighbour is parent 
        }
    }

    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        CreateGraph(graph);

        int dt[] = new int[V];   // Discovery Time of Nodes (Time at which nodes are visited)
        int low[] = new int[V];  // Lowest Discovery Time Of all neighbour including node itself

        boolean visited[] = new boolean[V];
    
        System.out.println("Bridge Edges: ");
        for(int i = 0 ; i < V ; i++) {
            if(!visited[i]) {
                Tarjan(graph , 0 , -1 , dt , low , visited );
            }
        }
    }
}
