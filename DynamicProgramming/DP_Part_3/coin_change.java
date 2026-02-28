package DynamicProgramming.DP_Part_3;

// You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

// Return the number of combinations that make up that amount.If that amount of money cannot be made up by any combination of the coins,return 0.

// You may assume that you have an infinite number of each kind of coin.

public class coin_change {

    // Recursive Approch

    public static int coinChange(int coins[], int amount, int i) {  // O(2 ^ n)
        // Base Case
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }

        // Recursion

        // include coin and exclude coin
        int totalIncWays = 0;
        int totalExcWays = 0;

        // Include
        if (amount >= coins[i]) {
            totalIncWays = coinChange(coins, amount - coins[i], i); // Here we are including the same item because we have infinite supply of coins
        }

        // Exclude
        totalExcWays = coinChange(coins, amount, i + 1);

        return totalIncWays + totalExcWays;
    }

    // Memoization Approch
    public static int coinChangeMemo(int coins[], int dp[][], int amount, int i) { // TC :- O(amount * n)
        // Base Case
        if (amount == 0) {
            return 1;
        }
        if (i == coins.length) {
            return 0;
        }

        

        // if the problem already solved then reuse the result
        if(dp[i + 1][amount] != -1) {
            return dp[i + 1][amount];
        }

        // Recursion
        int totalIncWays = 0;
        int totalExcWays = 0;

        // Include
        if (amount >= coins[i]) {
            totalIncWays = coinChangeMemo(coins, dp, amount - coins[i], i); 
        }

        // Exclude
        totalExcWays = coinChangeMemo(coins, dp, amount, i + 1);

        // Store the Result first Then return
        dp[i + 1][amount] = totalIncWays + totalExcWays;
        return dp[i + 1][amount];
    }

    // Printing Table
    public static void PrintTable(int dp[][]) {
        for(int i = 0; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Tabulation Approch

    public static int coinChangeTab(int coins[] , int amount) {  // TC :- O(amount * n)
        // Make the table
        int dp[][] = new int[coins.length + 1][amount + 1];

        // Initialization
        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = 1;
        }

        // Meaning dp[i][j] -> Number of ways of i coins to give j amount

        // Filling Table (small to large)
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                int incWays = 0;
                // Include 
                if(j >= coins[i - 1]) {
                    incWays = dp[i][j - coins[i - 1]];
                }
                // Exclude
                int excWays = dp[i - 1][j];

                dp[i][j] = incWays + excWays;
            }
        }
        PrintTable(dp);
        return dp[coins.length][amount];
    }

    public static void main(String[] args) {
        int n = 3;
        int coins[] = { 1, 2, 5 };
        int amount = 5;

        // Recursion Approch
        System.out.println("Recursion Ans:- " + coinChange(coins, amount, 0));

        // Memoization Approch
        // DP Array
        int dp[][] = new int[n + 1][amount + 1];
        for(int i = 1 ; i <= n ; i++) {
            for(int j = 1 ; j <= amount ; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Memoization Ans:- " + coinChangeMemo(coins, dp, amount, 0));
        // PrintTable(dp);

        // Tabulation Approch
        System.out.println("Tabulation Ans:- " + coinChangeTab(coins, amount));
    }
}
