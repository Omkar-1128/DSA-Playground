package DynamicProgramming.DP_Part_4;

// Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

// You have the following three operations permitted on a word:
// Insert a character
// Delete a character
// Replace a character

public class EditDistance {

    public static int EDRecursion(String word1 , String word2 , int n , int m) {
        if(n == 0 && m == 0) {
            return 0;
        }

        // If any one String becomes 0 then minimum number of operations required are the length of other string
        if(n == 0) {
            return m;
        } 
        if(m == 0) {
            return n;
        }

        // If both the end Characters are same
        if(word1.charAt(n - 1) == word2.charAt(m - 1)) {
            return EDRecursion(word1, word2, n - 1, m - 1);
        } else {  // If both end charcters are different then we have thre choices
            int ans1 = EDRecursion(word1, word2, n, m - 1) + 1; // Add Operation
            int ans2 = EDRecursion(word1, word2, n - 1, m) + 1; // Remove Operation
            int ans3 = EDRecursion(word1, word2, n - 1, m - 1) + 1; // Replace Operation

            return Math.min(ans1, Math.min(ans2, ans3));
        }

    }

    public static int EDMemo(String word1 , String word2 , int n , int m , int dp[][]) {
        if(n == 0 && m == 0) {
            return 0;
        }

        // If any one String becomes 0 then minimum number of operations required are the length of other string
        if(n == 0) {
            return m;
        } 
        if(m == 0) {
            return n;
        }

        if(dp[n][m] != -1) {
            return dp[n][m];
        }

        // If both the end Characters are same
        if(word1.charAt(n - 1) == word2.charAt(m - 1)) {
            dp[n][m] = EDMemo(word1, word2, n - 1, m - 1 , dp);
        } else {  // If both end charcters are different then we have thre choices
            int ans1 = EDMemo(word1, word2, n, m - 1 , dp) + 1; // Add Operation
            int ans2 = EDMemo(word1, word2, n - 1, m , dp) + 1; // Remove Operation
            int ans3 = EDMemo(word1, word2, n - 1, m - 1 , dp) + 1; // Replace Operation

            dp[n][m] = Math.min(ans1, Math.min(ans2, ans3));
        }

        return dp[n][m];
    }   

    // Tabulation Approch   
    public static int EDTab(String word1 , String word2) {
        int n = word1.length();
        int m = word2.length();

        // Create the dp Table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning // dp[i][j] // Minimum number of operations to convert the word1 with length i into word2 with length j

        // Initialization
        // if both the length becomes 0 then return 0
        // if any one string becomes 0 then return the length of other string
        for(int i = 0 ; i < n + 1 ; i++) {
            dp[i][0] = i;  // if j becomes 0 store the length of i
        }
        for(int j = 0 ; j < m + 1 ; j++) {
            dp[0][j] = j;  // if i becomes 0 store the length of j
        }

        // Filling the table 
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                // If the char are same
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else { // If the character are different 
                    // 3 choices
                    // 1 add the charater
                    int ans1 = dp[i][j - 1] + 1;

                    // 2 remove the character
                    int ans2 = dp[i - 1][j] + 1;

                    // 3 replace the character
                    int ans3 = dp[i - 1][j - 1] + 1;

                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3));
                }
            }
        }
        PrintTable(dp);
        return dp[n][m];
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

    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";

        // String word1 = "horse";
        // String word2 = "ros";

        // Recursion
        // System.out.println(EDRecursion(word1, word2, word1.length(), word2.length()));

        // Memoization Approch
        int dp[][] = new int[word1.length() + 1][word2.length() + 1];
        // Initialization
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(EDMemo(word1, word2, word1.length(), word2.length(), dp));
        // PrintTable(dp);

        // Tabulation Approch
        // System.out.println(EDTab(word1, word2));
    }
}
