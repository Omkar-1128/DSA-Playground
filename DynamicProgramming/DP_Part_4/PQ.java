package DynamicProgramming.DP_Part_4;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

// Leetcode 1671
// 1671. Minimum Number of Removals to Make Mountain Array

public class PQ {

    // Steps
    // 1} Find the longest increasing subsequence // LIS
    // 2} Find the longest decreasing subsequence // LDS
    // 3} use formula minimum remove = LIS + LDS - 1

    // LIS
    public static int LIS(int arr[]) {
        // Make another sorted array in Ascending Order
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        int arr2[] = new int[set.size()];
        int l = 0;
        for (Integer val : set) {
            arr2[l++] = val;
        }

        Arrays.sort(arr2);

        int n = arr.length;
        int m = arr2.length;

        // use LCS to get LIS
        // Tabulation Approch

        // Create table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning
        // dp[i][j] => Longest Common Subsequence Between arr with length i and arr2
        // with length j

        // Initialization
        // if any array is 0 then nothing is common
        // default initialization

        // Filling the Table

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // if both the elements are equal
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // If both the elements are not equal
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];

    }

    public static int LDS(int arr[]) {
        // Make another sorted array in Descending order
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        Integer arr2[] = new Integer[set.size()];
        int l = 0;
        for (Integer val : set) {
            arr2[l++] = val;
        }

        Arrays.sort(arr2, Collections.reverseOrder());

        int n = arr.length;
        int m = arr2.length;

        // use LCS to get LDS
        // Tabulation Approch

        // Create table
        int dp[][] = new int[n + 1][m + 1];

        // Meaning
        // dp[i][j] => Longest Common Subsequence Between arr with length i and arr2
        // with length j

        // Initialization
        // if any array is 0 then nothing is common
        // default initialization

        // Filling the Table

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                // if both the elements are equal
                if (arr[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else { // If both the elements are not equal
                    int ans1 = dp[i - 1][j];
                    int ans2 = dp[i][j - 1];

                    dp[i][j] = Math.max(ans1, ans2);
                }
            }
        }

        return dp[n][m];

    }

    public static int GetMountainArray(int arr[]) {
        int lis = LIS(arr);
        int lds = LDS(arr);

        // Minimum Elements to remove
        int rem = arr.length - (lis + lds - 1);

        return rem;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 1, 5, 6, 2, 3, 1 }; // O/P :- 3
        // int arr[] = { 1, 3, 1 }; // O/P :- 0

        System.out.println("Minimum elements required to remove: " + GetMountainArray(arr));
    }
}
