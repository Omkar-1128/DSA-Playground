package GreedyAlgorithm;

import java.util.ArrayList;

// Maximum Balanced String Partitions
// We have balanced string str of size N with an equal number of L and R, the task is to find a
// maximum number X, such that a given string can be partitioned into X balanced substring. A
// string is called to be balanced if the number of ‘L’s in the string equals the number of ‘R’s.
// Input : “LRRRRLLRLLRL”
// Output : 3

// class Solution {
//     public int balancedStringSplit(String s) {
//         int l = 0;
//         int r = 0;
//         int ans = 0;

//         for (int i = 0 ; i < s.length() ; i++) {
//             char ch = s.charAt(i);

//             if (ch == 'L') {
//                 l++;
//             } else {
//                 r++;
//             }

//             if (l == r) {
//                 ans++;
//             }
//         }

//         return ans;
//     }
// }

public class PQ {
    // Kth largest odd number in a given range
    // We have two variables L and R, indicating a range of integers from L to R
    // inclusive, and a
    // number K, the task is to find Kth largest odd number. If K > number of odd
    // numbers in the range
    // L to R then return 0.
    // Sample Input 1 : L = -3, R = 3, K = 1
    // Sample Output 1 : 3

    // public static void main(String[] args) { // O(R - L + 1) -> O(n)
    // int L = -3;
    // int R = 3;
    // int k = 3;

    // if (k <= 0) {
    // System.out.println("Not Found");
    // }
    // int count = (int) (R - L + 1) / 2;// Total number of Odd numbers in the Range
    // if(k>count)
    // {
    //     System.out.println("Not Found");
    // }
    // ArrayList<Integer> OddNo = new ArrayList<>();

    // for (int i = L ; i <= R ; i++) {
    // if (i % 2 != 0) {
    // OddNo.add(i); // -3 , -1 , 1 , 3
    // }
    // }

    // int n = OddNo.size();

    // System.out.println(OddNo.get(n - k));
    // }

    // Optimized - O(1)
    // public static void main(String[] args) {
    //     int L = 1;
    //     int R = 10;
    //     int k = 2;

    //     if (k <= 0) {
    //         System.out.println("Not Found");
    //     }

    //     int count = (int) (R - L + 1) / 2;// Total number of Odd numbers in the Range
    //     if (k > count) { 
    //         System.out.println("Not Found");
    //     }

    //     if ((R & 1) == 1) { // Last Digit is Odd Numebr
    //         System.out.println(R - 2 * k + 2); // returns Kth last Odd number
    //     } else { // Last digit is even Number
    //         System.out.println(R - 2 * k + 1); // returns Kth last Odd number
    //     }
    // }


//     410. Split Array Largest Sum
// Given an integer array nums and an integer k, split nums into k non-empty subarrays such that the largest sum of any subarray is minimized.
// Return the minimized largest sum of the split.
// A subarray is a contiguous part of the array.

//     class Solution {   O(n - 1)c(k - 1)
//     static int ans;
//     public static void solve(int a[] , int k , int n ,int index , int maxSum , int sum) {
//         // Base Case
//         if (k == 1) {
//             maxSum = Math.max(maxSum , sum);
//             sum = 0;
//             for (int i = index ; i < n ; i++) {
//                 sum += a[i];
//             }
//             maxSum = Math.max(maxSum , sum);
//             ans = Math.min(ans , maxSum);
//             return;
//         }

//         // Recursion
//         sum = 0;
//         for (int i = index ; i < n ; i++) {
//             sum += a[i];
//             maxSum = Math.max(maxSum , sum);
//             solve(a , k - 1 , n , i + 1 , maxSum , sum);
//         }
//     }

//     public int splitArray(int[] nums, int k) {
//         ans = Integer.MAX_VALUE;
//         int n = nums.length;
//         solve(nums , k , n , 0 , 0 , 0);
//         return ans;
//     }
// }
}


// 1663. Smallest String With A Given Numeric Value

// class Solution {
//     public String getSmallestString(int n, int k) {
//         char arr[] = new char[n];
//         Arrays.fill(arr , 'a');
//         int i = n - 1;

//         k -= n;
//         while (k > 0 && i >= 0) {
//             if (k >= 25) {
//                 arr[i] = (char) ('a' + 25);  // add z in the array
//                 k -= 25;  
//             } else {
//                 arr[i] = (char) ('a' + k ); 
//                 k = 0;
//             }
//             i--;
//         }

//         return new String(arr);
//     }
// }
