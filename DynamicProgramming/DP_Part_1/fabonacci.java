package DynamicProgramming.DP_Part_1;

public class fabonacci {

    // Recursion Approch  // TC -> O(2 ^ n)
    public static int Fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        } 

        return Fib(n - 1) + Fib(n - 2);
    }

    // Dynamic Programming Approch  // TC -> O(n)

    // Memoization Approch  
    public static int Fib(int n , int[] dp) {
        if(n == 0 || n == 1) {
            return n;
        }

        // If result already present in the dp then use it
        if(dp[n] != 0) {
            return dp[n];
        }

        // If not present then store it and return it
        dp[n] = Fib(n - 1) + Fib(n - 2);

        return dp[n];
    }

    // Tabulation Approch
    public static void FibTab(int n) {

        int dp[] = new int[n + 1];

        // Initialization ( These are mainly base cases for the recursion )
        dp[0] = 0;
        dp[1] = 1;

        // try to solve first small problem the solve large problems
        for(int i = 2 ; i <= n ; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        // Printing the table which is formed in the tabulation approch
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        System.out.println(dp[n]);
    }

    public static void main(String[] args) {
        int n = 6;
        int dp[] = new int[n + 1];

        // recursive approch
        System.out.println(Fib(n));

        // dp Memoization
        System.out.println(Fib(n , dp));

        // dp tabulation
        FibTab(n);
    }
}
