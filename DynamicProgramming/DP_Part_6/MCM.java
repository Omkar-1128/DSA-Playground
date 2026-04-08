package DynamicProgramming.DP_Part_6;

import java.util.Arrays;

//Matrix Chain Multiplication

// 👉 You are given an array:

// arr = [1, 2, 3, 4, 3]

// 👉 This represents matrices:
// A → 1×2
// B → 2×3
// C → 3×4
// D → 4×3

// Goal

// 👉 Multiply all matrices in such an order that:

// ✅ Total multiplication cost is minimum  

// Total multiplication between two matrix A[a * b]*B[b * c] => a * b * c

public class MCM {

    // Recursive Approch

    public static int MCMRec(int arr[] , int st , int ed) {
        // st :- start point
        // ed :- end point
        // base case -> single matrix
        if(st >= ed) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for(int k = st ; k < ed ; k++) {
            // st to k matrix solution
            int cost1 = MCMRec(arr, st, k);   // Ast --- Ak => arr[st - 1] x arr[k]

            // k to end matrix solution
            int cost2 = MCMRec(arr, k + 1, ed);  // Ak+1 --- Aed => arr[k] x arr[ed]
            
            // current cost
            int cost3 = arr[st - 1] * arr[k] * arr[ed];

            int finalcost = cost1 + cost2 + cost3;

            minCost = Math.min(minCost, finalcost);
        }

        return minCost;
    }

    // Memoization Approch   :- O(n2)
  
    public static int MCMMemo(int arr[] , int i , int j , int[][] dp) {
        // i => start point
        // j => end point
        // base case
        if(i == j) {
            return 0;
        }

        // The MCM is already calculated or not
        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        int ans = Integer.MAX_VALUE;

        for(int k = i ; k < j ; k++) {
            // cost1 => Ai to Ak => size([i - 1 x k])
            int cost1 = MCMMemo(arr, i, k, dp);
            
            // cost => Ak+1 to Aj-1 => size([k x j])
            int cost2 = MCMMemo(arr, k + 1, j, dp);

            // current cost
            int cost3 = arr[i - 1] * arr[k] * arr[j];

            int finalCost = cost1 + cost2 + cost3;

            ans = Math.min(ans , finalCost);
        }

        return dp[i][j] = ans;
    }

    // Print Table
    public static void PrintTable(int dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    // Tabulation Approch

    public static int MCMTab(int arr[]) {
        int n = arr.length;

        // Create the table
        int dp[][] = new int[n][n];

        // meaning 
        // dp[i][j] => minimum cost of matrix chain multiplication with starting point i and ending point j  

        // Initization 
        // when i and j equals then the cost is 0
        // it does not matter if the start point (i) or end point (j) will be 0

        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                if(i == j) {
                    dp[i][j] = 0;
                }
            }
        }

        // solution
        for(int len = 2 ; len <= n - 1 ; len++) {
            for(int i = 1 ; i <= n - len ; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i ; k <= j - 1 ; k++) {
                    int cost1 = dp[i][k];
                    int cost2 = dp[k + 1][j];
                    int cost3 = arr[i - 1] * arr[k] * arr[j];
                    dp[i][j] = Math.min(dp[i][j] , cost1 + cost2 + cost3);
                }
            }
        }   

        // PrintTable(dp);

        return dp[1][arr.length - 1];
    }

    public static void main(String[] args) {
        int arr[] = {1 , 2 , 3 , 4 , 3};
        // Mtrices :- A[1 * 2] , B[2 * 3] , C[3 * 4] , D[4 * 3]

        System.out.println("Recursion Ans:- " + MCMRec(arr, 1, arr.length - 1));

        // Memoization
        int dp[][] = new int[arr.length - 1][arr.length];

        for(int i = 0 ; i < dp.length ; i++) {
            Arrays.fill(dp[i] , -1);
        }

        System.out.println("Memoization ans:- " + MCMMemo(arr, 1, arr.length - 1, dp));

        // Print the memo table
        // PrintTable(dp);

        // Tabulation answer
        System.out.println("Tabulation ans:- " + MCMTab(arr));
    }
}
