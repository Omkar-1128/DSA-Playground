// package DynamicProgramming.DP_Part_5;

public class Wildcard_Pattern {

    // Recursion Approch

    public static boolean checkWildCard(String s , String p , int n , int m) {

        // Base Case

        if( n == 0 && m == 0) {
            return true;
        } else if(m == 0) {
            return false;
        } else if(n == 0) {
            if(p.charAt(m - 1) == '*') {
                return checkWildCard(s , p , n , m - 1);
            } else {
                return false;
            }
        }

        // Approch

        if(s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
            return checkWildCard(s, p, n - 1, m - 1);
        } else if(p.charAt(m - 1) == '*') {
            boolean ans1 = checkWildCard(s, p, n - 1, m);  // check for sequence
            boolean ans2 =  checkWildCard(s, p, n, m - 1);  // ignore the *

            return ans1 || ans2;
        } else {
            return false;
        }
    }

    // Memoization Approch

    public static boolean WildCardMemo(String s , String p , int n , int m , Boolean dp[][]) {
        // The The Values are already calculated or not
        if(dp[n][m] != null) {
            return dp[n][m];
        }

        // Base Case
        if( n == 0 && m == 0) {
            return true;
        } else if(m == 0) {
            return false;
        } else if(n == 0) {
            if(p.charAt(m - 1) == '*') {
                return WildCardMemo(s , p , n , m - 1 , dp);
            } else {
                return false;
            }
        }
        
        // Approch

        if(s.charAt(n - 1) == p.charAt(m - 1) || p.charAt(m - 1) == '?') {
            dp[n][m] = WildCardMemo(s, p, n - 1, m - 1 , dp);
        } else if(p.charAt(m - 1) == '*') {
            boolean ans1 = WildCardMemo(s, p, n - 1, m , dp);  // check for sequence
            boolean ans2 =  WildCardMemo(s, p, n, m - 1 , dp);  // ignore the *

            dp[n][m] = ans1 || ans2;
        } else {
            dp[n][m] = false;
        }

        return dp[n][m];
    } 

    // Tabulation Approch

    public static boolean WildCardTab(String s , String p) {
        int n = s.length();
        int m = p.length();

        // Create the Table
        Boolean dp[][] = new Boolean[n + 1][m + 1];

        // Meaning 
        // dp[i][j] = true -> the pattern with length j can make the string of length i

        // Initialization
        // dp[0][0] = true -> always equal when both string has 0 length
        // dp[i][0] = false -> Not Possible to make the string which has i length
        // dp[0][j] if(we get * at last idx) then dp[0][j] = dp[0][i - 1] else dp[0][j] = false

        dp[0][0] = true;
        for(int i = 1 ; i < n + 1 ; i++) {
            dp[i][0] = false;
        }
        for(int j = 1 ; j < m + 1 ; j++) {
            if(p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            } else {
                dp[0][j] = false;
            }
        }

        // Filling the Table 
        // Botton up approch
        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < m + 1 ; j++) {
                // if the last character is *
                if(p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else if(p.charAt(j - 1) == '?' || s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        PrintTable(dp);
        return dp[n][m];
    } 

    // Print Table
    public static void PrintTable(Boolean dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // String s = "abc";  // String of length n
        // String p = "**?b*";  // Pattern of length m
        
        // String s = "aa";
        // String p = "*";

        // String s = "baaabab";
        // String p = "*****ba*****ab";
        String s = "baaabab";
        String p = "a*ab";

        System.out.println("Recursion Solution:- " + checkWildCard(s, p, s.length(), p.length()));

        // Memoization Approch
        // Create the Table
        Boolean dp[][] = new Boolean[s.length() + 1][p.length() + 1];

        System.out.println("Memoization Solution:- " + WildCardMemo(s, p, s.length(), p.length() , dp));

        System.out.println("Tabulation Answer: " + WildCardTab(s, p));
    }
}
