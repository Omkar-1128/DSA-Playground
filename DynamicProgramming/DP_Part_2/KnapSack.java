package DynamicProgramming.DP_Part_2;

public class KnapSack {

    // Recursive Approch
    public static int CalProfit(int val[], int wt[], int W, int i) {   // TC :- O(2^n) 
        if (W == 0 || i == 0) {
            return 0;
        }

        int ans1 = 0;
        // Include the item
        if(W >= wt[i - 1]) {   // Valid 
            ans1 = val[i - 1] + CalProfit(val, wt, W - wt[i - 1], i - 1);
        }
        
        // Exclude the item
        int ans2 = CalProfit(val, wt, W, i - 1);

        return Math.max(ans1 , ans2);
    }

    // Memoization Approch

    public static int ProfitMemo(int val[], int wt[], int W, int i , int dp[][]) {  // TC :- O(n * W)
        if (W == 0 || i == 0) {
            return 0;
        }

        if(dp[i][W] != -1) {
            return dp[i][W];
        } 

        int ans1 = 0;
        // Include the item
        if(W >= wt[i - 1]) {   // Valid 
            ans1 = val[i - 1] + ProfitMemo(val, wt, W - wt[i - 1], i - 1 , dp);
        }
        
        // Exclude the item
        int ans2 = ProfitMemo(val, wt, W, i - 1 , dp);

        dp[i][W] = Math.max(ans1 , ans2);
        return dp[i][W];
    }

    // Tabulation Approch
    public static int ProfitTab(int val[] , int wt[] , int W) {
        // Creating and Initializing the table
        // Initialization cases W == 0 Or i == 0 
        // already present in the DP table No need to initialize
        int dp[][] = new int[val.length + 1][W + 1];

        // Meaning of dp[i][j] -> Maximum profit for i items and j weight 

        // Filling the table
        for(int i = 1 ; i < val.length + 1 ; i++) {
            for(int j = 1 ; j < W + 1 ; j++) {
                // Get the curr val  ans wt
                int currVal = val[i - 1];  // value of ith item
                int currWt = wt[i - 1];  // Weight of ith item

                int incProfit = 0;
                if(currWt <= j) {  // Valid Case Include 
                    incProfit = currVal + dp[i - 1][j - currWt];
                }

                // Exclude case
                int excProfit = dp[i - 1][j];

                dp[i][j] = Math.max(incProfit , excProfit);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;

        // Recursive Approch
        int profit = CalProfit(val, wt, W, val.length);
        System.out.println("Max Profit Recursion: " + profit );

        int dp[][] = new int[val.length + 1][W + 1];
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }
        int MemoProfile = ProfitMemo(val, wt, W, val.length, dp);
        System.out.println("Max Profit Memoization: " + MemoProfile );

        int TabProfit = ProfitTab(val, wt, W);
        System.out.println("Max Profit Memoization: " + TabProfit );
    }
}
