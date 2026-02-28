package DynamicProgramming.DP_Part_3;

public class Rod_Cutting {
    // The Question is Similar to 0/1 KnapSack   Weight :- Length and Val :- Price
    // We Have to Calculate the Maximum Profite

    // Tabulation Approch

    public static int MaxProfite(int length[] , int price[] , int rodLength) {
        // Creating the Table
        int dp[][] = new int[length.length + 1][rodLength + 1];

        // Meaning -> dp[i][j] -> Maximum Profit after cutting the rod of length j into i length pieces 

        // Initialization 
        // If the Length Of Rod is 0 Then the No. Of Pieces to get the max Profit also 0 dp[i][0] = 0
        // also If the no. Of Pieces of rod are zero then Maximum Profit for length of rod is 0 dp[0][j] = 0;

        // Filling the Table
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                if(length[i - 1] <= j) { // Valide Case
                    dp[i][j] = Math.max(dp[i - 1][j] , price[i - 1] + dp[i][j - length[i - 1]]);
                } else {    // InValid Case
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        PrintTable(dp);
        return dp[length.length][rodLength];
    }

    // Print table
    public static void PrintTable(int dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    // Memoization Approch

    public static int MaxProfitMemo(int length[] , int price[] , int rodLength , int i , int dp[][]) {
        // Base Case
        if(rodLength == 0 || i == 0) {
            return 0;
        }

        if(dp[i][rodLength] != -1) {
            return dp[i][rodLength];
        }

        // recursion

        // Include Item
        int IncProfit = 0;
        if(length[i - 1] <= rodLength) {
            IncProfit = price[i - 1] + MaxProfitMemo(length, price, rodLength - length[i - 1], i, dp);
        }

        int ExcProfit = MaxProfitMemo(length, price, rodLength, i - 1, dp);

        dp[i][rodLength] = Math.max(IncProfit, ExcProfit);
        return dp[i][rodLength];
    }

    public static void main(String[] args) {
        int length[] = {1 , 2 , 3 , 4 , 5 , 6 , 7 , 8};
        int price[] = {1 , 5 , 8 , 9 , 10 , 17 , 17 , 20};

        int rodLength = 8;

        System.out.println("Tabulation Approch Max Profit :- " + MaxProfite(length, price, rodLength));
        
        // Memoization Approch
        
        int dp[][] = new int[length.length + 1][rodLength + 1];
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("Mamoization Approch Max Profit :- " + MaxProfitMemo(length, price, rodLength, rodLength, dp));
        // PrintTable(dp);

    }
}
