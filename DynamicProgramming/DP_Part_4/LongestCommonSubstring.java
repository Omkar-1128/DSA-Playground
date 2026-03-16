package DynamicProgramming.DP_Part_4;

// Find the longest common SubString form two Strings 

public class LongestCommonSubstring {

    public static int longestSubstring = 0;
    public static int longestSubstringMemo = 0;

    // Recursive Approch
    public static int LCS(String s1 , String s2 , int n , int m) {  // O(2 ^ n)
        if(n == 0 || m == 0) {
            return 0;
        }   

        int length = 0;

        // If both character at the end of string are equal
        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            length = 1 + LCS(s1 , s2 , n - 1 , m - 1);
        } else {  // If both the character are different 
            LCS(s1 , s2 , n - 1 , m);
            LCS(s1 , s2 , n, m - 1);
        }

        longestSubstring = Math.max(longestSubstring, length);
        return length;
    }

    // Memoization Approch
    public static int LCSMemo(String s1 , String s2 , int n , int m , int dp[][]) {  // O(n * m)
        if(n == 0 || m == 0) {
            return 0;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        if(s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + LCSMemo(s1, s2, n - 1, m - 1 , dp);
        } else {
            LCSMemo(s1, s2, n, m - 1 , dp);
            LCSMemo(s1, s2, n - 1, m , dp);

            dp[n][m] = 0;
        }
        longestSubstringMemo = Math.max(longestSubstringMemo, dp[n][m]);
        return dp[n][m];
    }

    // Tabulation Approch
    public static int LCSTabulation(String s1 , String s2) {  // O(n * m)
        int SubStringMaxLength = 0;

        // Create the table
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n + 1][m + 1];

        // Meaning :- dp[i][j] = the longest common substring of s1 with length i and s2 with length j

        // Initialization
        // if any one string becomes 0 then the length also becomes 0
        // dp[i][0] = 0 , dp[0][j] = 0;  default initilized

        // Filling the table
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    SubStringMaxLength = Math.max(SubStringMaxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        PrintTab(dp);
        return SubStringMaxLength;
    }

    // Print the table
    public static void PrintTab(int dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s1 = "ABGCE";
        String s2 = "ABCDE";

        // Recursive Approch
        // LCS(s1, s2, s1.length(), s2.length());
        // System.out.println(longestSubstring);

        // Tabulation Approch
        // System.out.println(LCSTabulation(s1, s2));

        // Memoization Approch
        int dp[][] = new int[s1.length() + 1][s2.length() + 1];
        
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }

        LCSMemo(s1, s2, s1.length(), s2.length(), dp);
        // PrintTab(dp);
        System.out.println(longestSubstringMemo);
    }
}
