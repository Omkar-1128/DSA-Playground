package Backtracking;

public class GenerateParanthesis {

//     Print all combinations of balanced parentheses
//       Write a function to generate all possible n pairs of balanced parentheses..
//       Input: n=1
//       Output: {}
//       Input : n=2
//       Output: {}{} {{}}

    public static void Rec(int n , int open , int close , StringBuilder s) {
        if(s.length() == n * 2) {
            System.out.print(s.toString() + "  ");
            return;
        }

        if(open < n) {
            Rec(n, open + 1, close, s.append('{'));
            s.deleteCharAt(s.length() - 1);
        }
        if(close < open) {
            Rec(n, open, close + 1, s.append('}'));
            s.deleteCharAt(s.length() - 1);
        }
    }

    // Print Total Number Of Parenthesis is a catalan's number

    public static int Catalan(int n) {

        if(n == 0) {
            return 0;
        }
 
        // Dp Tabulation Approch

        // Create Table
        int dp[] = new int[n + 1];

        // initialization
        dp[0] = 1;
        dp[1] = 1;

        // Filing the Table

        for(int i = 2 ; i < n + 1 ; i++) {
            int totalN = 0;
            for(int j = 0 ; j < i ; j++) {
                totalN += dp[j] * dp[i - j - 1]; 
            }
            dp[i] = totalN;
        }

        // PrintTable(dp);
        return dp[n];
    }

    // Print Table
    public static void PrintTable(int dp[]) {
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print("Total Combinations -> ");
        Rec(n, 0, 0, new StringBuilder());
        System.out.println();
        System.out.println("Total Number Of Parenthesis: "+ Catalan(n));
        
    }
}
