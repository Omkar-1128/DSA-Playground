package DynamicProgramming.DP_Part_6;

public class MinimumPartitioning {
    // Minimum Partition
    // 👉 You are given a list of numbers (like: 1, 6, 11, 5)

    // 👉 Your task is:

    // Divide these numbers into 2 groups (subsets)
    // Such that the difference of their sums is minimum

    // We Have to solve this question similar to knapsack
    // capacity :- total sum / 2
    // wt and value arr = arr

    // DP Tabualtion approch

    // TC :- O(n * sum / 2)  or O(n * W(capacity))
    public static int MPTab(int arr[]) {
        int n = arr.length;
        // Step 1 calculate total sum
        int TotalSum = 0;
        for (int i = 0; i < n; i++) {
            TotalSum += arr[i];
        }

        // now the capacity like knapsack is totalsum / 2
        int capacity = TotalSum / 2;

        // Make the dp array
        int dp[][] = new int[n + 1][capacity + 1];

        // meaning
        // dp[i][j] => sum1 with i length subset and j capacity(sum / 2)

        // initialization
        // if the arr length is 0 or capacity is 0 then minimum difference is also 0
        // default initilization

        // Filling the table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < capacity + 1; j++) {
                int incSum = 0;
                int excSum = 0;
                // include the element
                if (arr[i - 1] <= j) {
                    incSum = arr[i - 1] + dp[i - 1][j - arr[i - 1]];
                }
                // exclude the element
                excSum = dp[i - 1][j];

                dp[i][j] = Math.max(incSum, excSum);
            }
        }
        // PrintTable(dp);
        int sum1 = dp[n][capacity];

        int sum2 = TotalSum - sum1;

        return Math.abs(sum1 - sum2);
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

    public static void main(String[] args) {
        int arr[] = { 1, 6, 11, 5 };

        System.out.println("Minimum Difference: " + MPTab(arr));
    }
}
