package DynamicProgramming.DP_Part_4;

import java.util.*;

public class LongestIncreasingSubSequence {

    // Tabulation Approch

    public static int LIS(int arr1[], int arr2[]) {  // O(n * m)
        int n = arr1.length;
        int m = arr2.length;

        // Create the Table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning:- dp[i][j] = Longest Increasing subsequence of arr1 and arr2 with
        // length i and j respectively.

        // Initialization
        // If any one array becomes 0 length then the subsquence will also be 0
        // dp[i][0] = 0 , dp[j][0] = 0 // Default initialization

        // Filling the Table
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // if both value matches
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else { // if both values are different
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }
        // PrintTable(dp);
        return dp[n][m];
    }

    // Print Table
    public static void PrintTable(int dp[][]) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int arr1[] = { 10, 9, 2, 5, 3, 7, 101, 18 };

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        int arr2[] = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            arr2[i++] = num;
        }

        Arrays.sort(arr2);

        System.out.println(LIS(arr1, arr2));
    }
}
