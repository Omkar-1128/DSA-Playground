package DynamicProgramming.DP_Part_1;

public class ClimbStairs {

    // Recursion TC -> O(2^n)
    public static int ways(int n) {
        // Base Case 
        if(n == 1 || n == 2) {
            return n;
        }

        return ways(n - 1) + ways(n - 2);
    }

    // Dynamic Programming  TC -> O(n)

    // Memoization
    public static int ways(int n , int[] dp) {
        if(n == 1 || n == 2) {
            return n;
        }

        if(dp[n] != 0) { // Already Calculated
            return dp[n];
        }

        dp[n] = ways(n - 1 , dp) + ways(n - 2 , dp);
        return dp[n];
    }

    // Tabulation
    public static void waysTab(int n) {
        int dp[] = new int[n + 1];

        // Initialization
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        // Filling the table
        // Tabulation Loop
        for(int i = 3 ; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Printing the dp Table
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        // answer
        System.out.println(dp[n]);
    }


    public static void main(String[] args) {
        int n = 5;  // ways(3) [3] + ways(4) [5] => [8]

        // recursion
        System.out.println(ways(n));

        // Memoization
        int dp[] = new int[n + 1];
        System.out.println(ways(n , dp));

        // Tabulation
        waysTab(n);
    }
}
