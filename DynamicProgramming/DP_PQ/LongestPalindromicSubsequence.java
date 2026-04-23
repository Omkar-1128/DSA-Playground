package DynamicProgramming.DP_PQ;
import java.util.*;

// Leetcode 516

public class LongestPalindromicSubsequence {

    // Tabulation Approch 

    // steps :- 
    //      first reverse the string
    //      then find the lcs between original and reverse string

    public static String revString(String s) {
        String r = "";

        for(int i = s.length() - 1 ; i >= 0 ; i--) {
            r += s.charAt(i);
        }

        return r;
    }

    public static int getLPS(String s) {
        String r = revString(s);
        int n = s.length();

        // Create the Table
        int dp[][] = new int[n + 1][n + 1];

        // meaning 
        // dp[i][j] => lcs of string s with length i and string j with length j

        // Initialization
        // if any one string becomes zero the lcs is also 0
        // Default Initialization

        for (int i = 1 ; i < n + 1 ; i++) {
            for (int j = 1 ; j < n + 1 ; j++) {
                // if both characters are equal
                if(s.charAt(i - 1) == r.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {  // if not equal
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        PrintTable(dp);

        return dp[n][n];
    }

    // Print table
    public static void PrintTable(int dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for (int j = 0 ; j < dp[0].length ; j++) {
                System.out.print( dp[i][j] + " " );
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "bbbab";

        System.out.println(getLPS(s));
    }
}
