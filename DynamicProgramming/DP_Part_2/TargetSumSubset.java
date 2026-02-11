package DynamicProgramming.DP_Part_2;

import java.util.*;

public class TargetSumSubset {

    // Recusrsive Approch   // TC:- 2^n

    public static void TargetSum(int arr[], int i, List<Integer> ans, int sum, int target) {
        if (i >= arr.length) {
            if (sum == target) {
                System.out.println(ans);
            }
            return;
        }

        // Include the ith item
        ans.add(arr[i]);
        TargetSum(arr, i + 1, ans, sum + arr[i], target);
        ans.remove(ans.size() - 1);

        // exclude the ith item
        TargetSum(arr, i + 1, ans, sum, target);
    }

    // Print the dp Array
    public static void print(boolean dp[][]) {
        for(int i = 0 ; i < dp.length ; i++) {
            for(int j = 0 ; j < dp[0].length ; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Tabulation Approch

    public static boolean TargetSumTab(int arr[] , int target) {
        // Creating and initializing the array
        boolean dp[][] = new boolean[arr.length + 1][target + 1];

        // Initialize the dp array first col with true values.
        // Intialize the first row from idx 1 with false values.  These are the default values

        for(int i = 0 ; i < dp.length ; i++) {
            dp[i][0] = true;
        }

        // now filling the values
        for(int i = 1 ; i < dp.length ; i++) {
            for(int j = 1 ; j < dp[0].length ; j++) {
                
                // Include the item
                boolean incItem = false;
                if(arr[i - 1] <= j) {
                    incItem = dp[i - 1][j - arr[i - 1]];
                }

                // Exclude the item
                boolean excItem = dp[i - 1][j];

                dp[i][j] = incItem || excItem;
            }
        }

        print(dp);

        return dp[dp.length - 1][dp[0].length - 1];
    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        int target = 10;
        // TargetSum(arr, 0, new ArrayList<>(), 0, target);

        System.out.println(TargetSumTab(arr, target));
    }
}
