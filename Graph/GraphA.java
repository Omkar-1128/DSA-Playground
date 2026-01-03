package Graph;
import java.util.*;

public class GraphA {

    // Creating a Graph using Adjacency List

    static class Edge {
        int src;
        int des;
        int wt;

        public Edge(int src , int des , int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {

        //      (5)
        //  0 ------- 1
        //           / \
        //       (1)/   \(3)
        //         /     \
        //        2 ----- 3
        //        |   (1)
        //     (2)|
        //        |
        //        4

        // Store the graph in the form of adjacency List

        int V = 5;
        
        @SuppressWarnings("unchecked")
        ArrayList<Edge>[] arr = new ArrayList[V];

        for(int i = 0 ; i < V ; i++) {
            arr[i] = new ArrayList<>();  // initilize each array box with empty list
        }

        // All edges from vertex 0
        arr[0].add(new Edge(0, 1, 5));

        // All edges from vertex 1
        arr[1].add(new Edge(1, 0, 5));
        arr[1].add(new Edge(1, 2, 1));
        arr[1].add(new Edge(1, 3, 3));

        // All edges from vertex 2
        arr[2].add(new Edge(2, 1, 1));
        arr[2].add(new Edge(2, 3, 1));
        arr[2].add(new Edge(2, 4, 2));

        // All edges from vertex 3
        arr[3].add(new Edge(3, 1, 3));
        arr[3].add(new Edge(3, 2, 2));

        // All edges from vertex 4
        arr[4].add(new Edge(4, 2, 2));

        // Print all the neighbour of the node 2
        System.out.print("Neighbour Of Node 2: ");
        for(int i = 0 ; i < arr[2].size() ; i++) {
            System.out.print(arr[2].get(i).des + " ");
        } 
        
    }
}
