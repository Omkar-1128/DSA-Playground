package Graph2.GraphSupplemental;
import java.util.*;

// Kosaraju's algorithm is used to find the strongly connected components 
// Steps: 
// 1] Get nodes in the stack (Topological Sort)
// 2] Transpose the graph
// 3] Do dfs accordingly to stack nodes on the Transpose graph

// TC = O(V + E)
public class Kosaraju_SCC {

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        graph[0].add(new Edge(0, 3));
        graph[0].add(new Edge(0, 2));
        graph[1].add(new Edge(1, 0));
        graph[2].add(new Edge(2, 1));
        graph[3].add(new Edge(3, 4));
    }

    public static void createTransposeGraph(ArrayList<Edge>[] graph , ArrayList<Edge>[] transposeGraph) {
        for(int i = 0 ; i < graph.length ; i++) {
            for(int j = 0 ; j < graph[i].size() ; j++) {
                Edge e = graph[i].get(j);

                transposeGraph[e.des].add(new Edge(e.des, e.src));
            }
        }
    }

    // Topological Sort using DFS // O(V + E)
    public static void TopologicalSort(ArrayList<Edge>[] graph , Stack<Integer> stack , int curr , boolean[] visited) {
        visited[curr] = true;

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.des]) {
                TopologicalSort(graph, stack, e.des, visited);
            }
        }

        stack.push(curr);
    }

    // O(V + E)
    public static void dfs(ArrayList<Edge>[] graph , int curr , boolean[] visited) {
        visited[curr] = true;
        System.out.print(curr + " ");

        for(int i = 0 ; i < graph[curr].size() ; i++) {
            Edge e = graph[curr].get(i);

            if(!visited[e.des]) {
                dfs(graph, e.des, visited);
            }
        }
    }

    // O(V + E)
    public static void Kosaraju(ArrayList<Edge>[] graph) {
        // step 1:  Make Stack Using Topological Sort 
        Stack<Integer> s = new Stack<>();
        boolean[] visited = new boolean[graph.length];
        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                TopologicalSort(graph, s, i, visited);
            }   
        }

        // step 2: make the Transpose graph
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] transposeGraph = new ArrayList[graph.length];
        for(int i = 0 ; i < transposeGraph.length ; i++) {
            transposeGraph[i] = new ArrayList<>();
        }
        createTransposeGraph(graph, transposeGraph);  // Reverse Edges

        // Step 3: Do dfs on Transpose Graph according to stack nodes
        for(int i = 0 ; i < graph.length ; i++) {
            visited[i] = false;
        }

        while(!s.isEmpty()) {
            int curr = s.pop();

            if(!visited[curr]) {
                System.out.print("SCC -> ");
                dfs(transposeGraph, curr, visited);
                System.out.println();
            }
        }
        
    }
 
    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        createGraph(graph);
        Kosaraju(graph);
    }
}
