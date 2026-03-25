public class MountainRanges {
    // Time Complexity :- O(n ^ 2)
    public static int countMountains(int n) {
        // Create the Table
        int dp[] = new int[n + 1];

        // Initialize
        dp[0] = 1;
        dp[1] = 1;

        // Filling the table
        for (int i = 2; i <= n; i++) {
            // i pairs -> Mountain Ranges => Ci
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];
                dp[i] += inside * outside;
            }
        }

        // PrintTable(dp);

        return dp[n];
    }

    // Print table
    public static void PrintTable(int dp[]) {
        for (int i = 0; i < dp.length; i++) {
            System.out.print(dp[i] + " ");
        }
    }

    public static void main(String[] args) {
        int n = 5;

        System.out.println("Total Number of Mountains With " + n + " Pairs Are " + countMountains(n));
    }
}
