package DynamicProgramming.DP_PQ;
import java.util.*;

// Tribonacci Numbers
// The Tribonacci series is a generalization of the Fibonacci sequence where each term is the sum
// of the three preceding terms.
// a(n) = a(n-1) + a(n-2) + a(n-3) with a(0) = a(1) = 0, a(2) = 1.


public class TribonacciNumber {

    // Recursive Approch
    public static int RecTN(int n) {
        if(n == 1 || n == 0) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
    
        return RecTN(n - 1) + RecTN(n - 2) + RecTN(n - 3);
    }

    // Memoization Approch

    public static int MemoTN(int n , int dp[]) {
        if(n == 1 || n == 0) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }

        if(dp[n] != -1) return dp[n];

        return dp[n] = MemoTN(n - 1 , dp) + MemoTN(n - 2 , dp) + MemoTN(n - 3 , dp);
    }

    // Tabulation Approch
    public static int TabTN(int n) {
        // create the table
        int dp[] = new int[n + 1];

        // initialize
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;

        // filling the table
        for(int i = 3 ; i < n + 1 ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        PrintTable(dp);
        return dp[n];
    }

    // Print Table
    public static void PrintTable(int dp[]) {
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print( dp[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 10;

        // System.out.println(RecTN(n));

        // Memozation Approch 
        // Make dp Array
        int dp[] = new int[n + 1];
        Arrays.fill(dp , -1);
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        MemoTN(n, dp);
        PrintTable(dp);

        // Tabulation Approch
        TabTN(n);
    }
}
