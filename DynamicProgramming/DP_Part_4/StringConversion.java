package DynamicProgramming.DP_Part_4;

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:
// Insert a character
// Delete a character

// This Question is similar to Edit Distance just difference is only two operations are alowed in this question

public class StringConversion {

    // DP Tabulation Approch    
    // Method 1 :- using similar approch as Edit Distance
    public static int SCTab(String str1 , String str2) {
        int n = str1.length();
        int m = str2.length();
        // Create the Table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning 
        // dp[i][j] -> Minimum Operation Required to convert the String 1 into String 2

        // Initialization
        // If any one string becomes zero then the minimum operation required are the length of another string

        for(int i = 0 ; i < n + 1 ; i++) {
            dp[i][0] = i;
        }

        for(int j = 0 ; j < m + 1 ; j++) {
            dp[0][j] = j;
        }

        // Filling the table
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                // Case 1 if the both the chars are same
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  
                } else { // If both characters are different
                    int add = dp[i][j - 1] + 1;
                    int del = dp[i - 1][j] + 1;

                    dp[i][j] = Math.min(add , del);
                }
            }
        }

        return dp[n][m];
    }

    // Method 2 : By Calcualting LCS

    public static int getLCS(String str1 , String str2) {
        int n = str1.length();
        int m = str2.length();

        // Creating a table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning 
        // dp[i][j] -> longest common sebsequence length of str1 with length i and str2 with length j

        // Initialization
        // if the any string length becomes 0 then the LCS also be 0
        // dp[i][0] = 0 && dp[0][j] = 0   // Default Initialization

        // Filling the Table
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                // if both the characters are same
                if(str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {  // If the both characters are different
                    dp[i][j] = Math.max(dp[i - 1][j] , dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int SCMeth2(String str1 , String str2) {
        int n = str1.length();
        int m = str2.length();
        // First Calcualte the length of LCS
        int lcs = getLCS(str1, str2);

        return (n - lcs) + (m - lcs);
    }

    public static void main(String[] args) {
        String str1 = "pear";
        String str2 = "sea";

        System.out.println("Method 1 ans: " + SCTab(str1, str2));

        // System.out.println(getLCS(str1, str2));

        System.out.println("Method 2 ans: " + SCMeth2(str1, str2));
    }   
}
