package Graph;
import java.util.*;
    
// Detect Cycle in Directed Graph Using DFS
public class CycleDetectionDirected {

    static class Edge {
        int src;
        int des;

        public Edge (int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    // O(V + E)
    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];
        boolean stack[] = new boolean[graph.length];

        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                if(isCyclicUtil(graph , i , visited , stack)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(ArrayList<Edge>[] graph , int curr , boolean[] visited , boolean[] stack ) {
        visited[curr] = true;
        stack[curr] = true;

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            if(stack[e.des]) {  // Cycle Exist
                return true;
            }

            if(!visited[e.des]) {
                return isCyclicUtil(graph, e.des, visited, stack);
            }
        }

        stack[curr] = false;

        return false;
    }

    public static void main(String[] args) {

        int V = 4;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        // For Below Graph the Cycle Does Not Exits

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));

        graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2, 3));

        if(isCyclic(graph)) {
            System.out.println("Cycle Exist in the Graph");
        } else {
            System.out.println("Cycle Does not Exist in the Graph");
        }
    }
}
