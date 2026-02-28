package DynamicProgramming.DP_Part_3;

// LCS Longest Common Subsequence (Leetcode 1143) 

// Given two strings str1 and str2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

// A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

// For example, "ace" is a subsequence of "abcde".
// A common subsequence of two strings is a subsequence that is common to both strings.

public class LCS {

    // Recursive Approch  // TC :- O(2^n)

    public static int lcsRecursion(String str1, String str2, int n, int m) {
        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }

        // Recursion
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {  // Same
            return 1 + lcsRecursion(str1, str2, n - 1, m - 1);
        } else {   // Differnt
            int ans1 = lcsRecursion(str1, str2, n - 1, m);
            int ans2 = lcsRecursion(str1, str2, n, m - 1);

            return Math.max(ans1, ans2);
        }
    }

    // Memoization Approch   TC :- O(n * m)
    public static int lcsMemo(String str1, String str2, int n, int m, int dp[][]) {
        // Base Case
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        // Recursion
        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {  // Same
            dp[n][m] = 1 + lcsMemo(str1, str2, n - 1, m - 1, dp);
            return dp[n][m];
        } else {  // Different
            int ans1 = lcsMemo(str1, str2, n - 1, m, dp);
            int ans2 = lcsMemo(str1, str2, n, m - 1, dp);

            dp[n][m] = Math.max(ans1, ans2);
            return dp[n][m];
        }
    }

    // Tabulation Approch  TC :- O(n * m)
    public static int lcsTab(String str1 , String str2) {
        int n = str1.length();
        int m = str2.length();

        // Creating the Table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning :- dp[i][j] = Longest common Subsequence for the str1 with length i and str2 with length j
        // Initialization 
        // If any one string becomes empty then the lcs will be 0
        // dp[i][0] = 0 and dp[0][j] = 0  //java Default Values

        // Filling the Table

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {  // Same 
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {  // Different
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];
                    dp[i][j] = Math.max(ans1 , ans2);
                }
            }
        }

        // PrintTable(dp);

        return dp[n][m];
    }

    // Printing the Table
    public static void PrintTable(int dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        } 

        System.out.println();
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        System.out.println("Recursion Answer:- " + lcsRecursion(str1, str2, str1.length(), str2.length()));

        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println("Memoization Answer:- " + lcsMemo(str1, str2, str1.length(), str2.length(), dp));


        System.out.println("Tabulation Answer:- " + lcsTab(str1, str2));
    }
}
