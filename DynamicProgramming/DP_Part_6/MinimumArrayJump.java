package DynamicProgramming.DP_Part_6;

public class MinimumArrayJump {

    // Problem Summary (Jump Game II)
    // You are given an array nums
    // Each element tells maximum jump length from that position
    // Start from index 0
    // You can jump forward within the allowed range
    // You must reach the last index (n - 1)
    // 🔹 Goal

    // 👉 Find the minimum number of jumps needed to reach the last index

    // DP Tabulation Approch

    public static int findMinimumJumps(int arr[]) {
        int n = arr.length;
        
        // Creating a table

        int dp[] = new int[n];

        // Meaning 
        // dp[i] => minimum jump from ith idx to n-1

        // Initialization
        dp[n - 1] = 0;

        for(int i = 0 ; i < n - 1 ; i++) {
            dp[i] = -1;
        }

        // Filling the table
        for(int i = n - 2 ; i >= 0 ; i--) {
            int minJump = Integer.MAX_VALUE;
            int steps = arr[i];
            for(int j = i + 1 ; j <= i + steps && j < n ; j++) {
                minJump = Math.min(minJump, dp[j] + 1);
            }
            if(minJump != Integer.MAX_VALUE) {
                dp[i] = minJump;
            }
        }

        // Printing the table
        for(int i = 0 ; i < dp.length ; i++) {
            System.out.print(dp[i] + " ");
        }
        System.out.println();

        return dp[0];
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 1, 1, 4 };

        System.out.println("Minimum jumps required:- " + findMinimumJumps(arr));
    }
}
