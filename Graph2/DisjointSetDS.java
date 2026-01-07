package Graph2;

public class DisjointSetDS {
    static int n = 8;
    static int[] par = new int[n];
    static int[] rank = new int[n];

    // Find function
    public static int find(int x) {
        if(x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);  // Path Optimization
    }

    public static void union(int a , int b) {
        int parA = find(a);
        int parB = find(b);

        if(rank[parA] == rank[parB]) {
            par[parB] = parA;
            rank[parA]++;
        } else if(rank[parA] > rank[parB]) {
            par[parB] = parA;
        } else {
            par[parA] = parB;
        }
    }

    public static void main(String[] args) {
        // Initialozation
        for(int i = 0 ; i < n ; i++) {
            par[i] = i;
            rank[i] = 0;
        }   


        System.out.println("Parent of 3: "  + find(3));
        union(1, 3);
        System.out.println("Parent of 3: "  + find(3));
        union(2, 4);
        union(3, 6);
        union(1, 4);
        System.out.println("Parent of 4: "  + find(4));
        union(1, 5);
    }
}
