package DynamicProgramming.DP_Part_2;

public class UnboundedKnapSack {

    // Tabulation Approch

    public static int UnboundedKnapSack(int val[] , int wt[] , int W) {
        int n = val.length;

        // Creating the Table
        int dp[][] = new int[n + 1][W + 1];

        // No Need of initialization because in java already all values are initialized with 0

        for(int i = 1 ; i < n + 1 ; i++) {
            for(int j = 1 ; j < W + 1 ; j++) {
                int incProfit = 0;
                if(wt[i - 1] <= j) {   // Valid Case (Include)
                    //including same item even it already included
                    incProfit = Math.max(val[i - 1] + dp[i][j - wt[i - 1]] , dp[i - 1][j]); 
                }

                int excProfit = dp[i - 1][j];

                dp[i][j] = Math.max(incProfit , excProfit);
            }
        }

        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = {15 , 14 , 10 , 45 , 30};
        int wt[] = {2 , 5 , 1 , 3 , 4};

        int W = 7;

        System.out.println(UnboundedKnapSack(val, wt, W));
    }
}
