public class CountBST {
    // Time Complexity :- O(n ^ 2)
    public static int countBST(int n) {
        // Create the Table
        int dp[] = new int[n + 1];

        // Initialize
        dp[0] = 1;   // Null Node
        dp[1] = 1;   

        // Filling the table
        for(int i = 2 ; i <= n ; i++) {
            for(int j = 0 ; j < i ; j++) {
                int left = dp[j];
                int right = dp[i - j - 1];
                dp[i] += left * right;
            }
        }

        // PrintTable(dp);

        return dp[n];
    }

    // Print table
    public static void PrintTable(int dp[]) {
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Total Number of Trees With " + n + " Node Are " + countBST(n));
    }
}
