package Graph;
import java.util.*;

public class CycleDectionUndirected {

    static class Edge {
        int src;
        int des;

        public Edge(int src , int des) {
            this.src = src;
            this.des = des;
        }
    }

    // Cycle Detection using DFS
    // O(V + E)
    public static boolean dfs(ArrayList<Edge>[] graph) {
        boolean visited[] = new boolean[graph.length];

        for(int i = 0 ; i < graph.length ; i++) {
            if(!visited[i]) {
                return dfsUtil(graph , visited , i , -1);
            }
        }

        return false;
    }

    public static boolean dfsUtil(ArrayList<Edge>[] graph , boolean[] visited, int curr , int parent) {
        visited[curr] = true;


        for(int i = 0 ; i < graph[curr].size() ; i++) {
            if((visited[graph[curr].get(i).des]) && (graph[curr].get(i).des != parent)) {
                return true;
            } else if(!visited[graph[curr].get(i).des]) {
                return dfsUtil(graph, visited, graph[curr].get(i).des, curr);
            }
        }

        return false;
    }

    public static void main(String[] args) {

        //         0 ---- 3
        //       / |
        //     1   |
        //       \ |
        //         2 ---- 4

        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] graph = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new Edge(0, 1));
        graph[0].add(new Edge(0, 2));
        graph[0].add(new Edge(0, 3));

        graph[1].add(new Edge(1, 0));
        graph[1].add(new Edge(1, 2));

        graph[2].add(new Edge(2, 1));
        graph[2].add(new Edge(2, 0));
        graph[2].add(new Edge(2, 4));

        graph[3].add(new Edge(3, 0));

        graph[4].add(new Edge(4, 2));

        if(dfs(graph)) {
            System.out.println("Cycle Exist in the graph");
        } else {
            System.out.println("Cycle does not Exist in the graph");
        }
        
    }
}
