package Graph2;

import java.util.*;

// Time Complexity : O(V) + O(ElogE)
public class kruskalsAlgorithm {

    static int n = 4;  // Vertices
    static int[] par = new int[n];
    static int[] rank = new int[n];

    static class Edge implements Comparable<Edge> {
        int src;
        int des;
        int wt;

        public Edge(int src, int des, int wt) {
            this.src = src;
            this.des = des;
            this.wt = wt;
        }

        @Override
        public int compareTo(Edge o) {
            return this.wt - o.wt;
        }
    }

    public static void init() {
        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 0;
        }
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public static void union(int a, int b) {
        int parA = find(a);
        int parB = find(b);

        if (rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if (rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void initEdges(ArrayList<Edge> edges) {
        edges.add(new Edge(0, 1, 10));
        edges.add(new Edge(0, 2, 15));
        edges.add(new Edge(0, 3, 30));
        edges.add(new Edge(1, 3, 40));
        edges.add(new Edge(2, 3, 50));
    }

    // Krushkals Algorithm
    public static int KrushkalAlgo(ArrayList<Edge> edges) {
        int minCost = 0;
        int count = 0;
        for (int i = 0; i < edges.size() && count < n - 1; i++) {
            Edge e = edges.get(i);
            int a = e.src;
            int b = e.des;

            if (find(a) != find(b)) {
                minCost += e.wt;
                union(a, b);
                count++;
            }

        }

        return minCost;
    }

    public static void main(String[] args) {
        init();

        ArrayList<Edge> edges = new ArrayList<>();

        initEdges(edges);
        Collections.sort(edges);  // O(ElogE)

        System.out.println("Minimum cost: " + KrushkalAlgo(edges));  // O(V)
    }
}
