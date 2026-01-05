package Graph;
import java.util.*;

public class TopologicalSorting_bfs {
    // find the Sorting order for the graph using BFS

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void TopologicalSorting(ArrayList<Edge>[] graph) {
        Queue<Integer> q = new LinkedList<>();
        int[] indegree = new int[graph.length];

        // Calculating indegree
        for(int i = 0 ; i < graph.length ; i++) {
            for(int j = 0 ; j < graph[i].size() ; j++) {
                Edge e = graph[i].get(j);

                indegree[e.des]++;
            }
        }

        for(int i = 0 ; i < indegree.length ; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        // bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            System.out.print(curr + " ");

            for(int i = 0 ; i < graph[curr].size() ; i++) {
                Edge e = graph[curr].get(i);

                indegree[e.des]--;

                if(indegree[e.des] == 0) {
                    q.add(e.des);
                }
            }
        }
    }



    public static void main(String[] args) {
        int V = 6;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[2].add(new Edge(2, 3));
        graph[3].add(new Edge(3, 1));
        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));
       
        System.out.print("Topological Sorting: ");
        TopologicalSorting(graph);
    }   
}
