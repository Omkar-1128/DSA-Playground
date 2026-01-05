package Graph;
import java.util.*;

public class TopologicalSorting_dfs {

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    // Topological Sorting using DFS
    // O(V + E)
    public static void TopologicalSort(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        Stack<Integer> s = new Stack<>();

        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                TopologicalSortUtil(graph, i, visited, s);
            }
        }

        while (!s.isEmpty()) {
            System.out.print(s.pop() + " ");
        }
    }

    public static void TopologicalSortUtil(ArrayList<Edge>[] graph , int curr , boolean[] visited , Stack<Integer> s) {
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.des]) {
                TopologicalSortUtil(graph, e.des, visited, s);
            }
        }

        s.push(curr);
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

        System.out.print("Topological Sorting -> ");
        TopologicalSort(graph);
    }
}
