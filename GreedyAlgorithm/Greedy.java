package GreedyAlgorithm;

import java.util.*;

public class Greedy {
    public static void main(String[] args) {
        // You are given two arrays A[] and B[], each containing n integers.
        // You need to pair each element of array A with exactly one element of array B
        // such that the sum of absolute differences of all pairs is minimized.
        // 🔹 Input:
        // An integer n (size of arrays).
        // Two arrays A[] and B[], each of size n.
        // 🔹 Output:
        // The minimum possible sum of absolute differences.

        // int A[] = {4 , 1 , 8 , 7}; // TC = O(nlogn)
        // int B[] = {2 , 3 , 6 , 5};
        // int minSum = 0;

        // Arrays.sort(A);
        // Arrays.sort(B);

        // for (int i = 0 ; i < A.length ; i++) {
        // minSum += Math.abs(A[i] - B[i]);
        // }

        // System.out.println("Minimum Sum -> " + minSum);

        // 646. Maximum Length of Pair Chain
        // You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and
        // lefti < righti.
        // A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can
        // be formed in this fashion.
        // Return the length longest chain which can be formed.
        // You do not need to use up all the given intervals. You can select pairs in
        // any order.
        // TC - O(nlogn) {Without Printing the pairs}
        // int pairs[][] = { { 5, 24 }, { 39, 60 }, { 5, 28 }, { 27, 40 }, { 50, 90 } };

        // ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // // Sorting
        // Arrays.sort(pairs , (a , b) -> a[1] - b[1]);

        // // Initialize with first Pair
        // int totalPairs = 1;
        // int lastEnd = pairs[0][1];
        // ArrayList<Integer> firstPair = new ArrayList<>();
        // firstPair.add(pairs[0][0]);
        // firstPair.add(pairs[0][1]);
        // list.add(firstPair);

        // for (int i = 1 ; i < pairs.length ; i++) {
        //     if (lastEnd < pairs[i][0]) {  
        //         totalPairs++;
        //         lastEnd = pairs[i][1];
        //         ArrayList<Integer> row = new ArrayList<>();
        //         row.add(pairs[i][0]);
        //         row.add(pairs[i][1]);
        //         list.add(row);
        //     }
        // }

        // System.out.println("Total Pairs -> " + totalPairs);
        // for (int i = 0 ; i < list.size() ; i++) {
        //     System.out.print(list.get(i) + " -> ");
        // }
        // System.out.println("|");


        // Indian Coin
        // Find min number of coin/notes to make a change for value v

        Integer coin[] = {1 , 2 , 5 , 10 , 20 , 50 , 100 , 500 , 2000};

        Arrays.sort(coin , Collections.reverseOrder());

        ArrayList<Integer> ans = new ArrayList<>();

        int amount = 1237;
        int count = 0;

        for (int i = 0 ; i < coin.length ; i++) {
            if (amount >= coin[i]) {
                while (amount >= coin[i]) {
                    count++;
                    ans.add(coin[i]);
                    amount -= coin[i];
                }
            }
        }

        System.out.println("total min coins used -> " + count);
        System.out.println("Coins -> " + ans);
    }
}
