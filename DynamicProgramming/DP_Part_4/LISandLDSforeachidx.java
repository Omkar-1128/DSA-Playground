package DynamicProgramming.DP_Part_4;

import java.util.Arrays;

public class LISandLDSforeachidx {

    public static void LIS(int arr[]) {
        if(arr.length == 0) {
            return;
        }

        int list[] = new int[arr.length];

        Arrays.fill(list, 1);  // each element has lis 1 which is itself

        for(int i = 0 ; i < arr.length ; i++) {
            for(int j = 0 ; j <= i - 1 ; j++) {  // increasing elements from 0 to i
                if(arr[i] > arr[j]) {
                    list[i] = Math.max(list[i] , list[j] + 1);
                }
            }
        }

        System.out.print("Longest Increasing Subsequence: ");
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();

    }

    public static void LDS(int arr[]) {
        if(arr.length == 0) {
            return;
        }

        int list[] = new int[arr.length];
        
        Arrays.fill(list, 1);  // each element has lis 1 which is itself

        for(int i = arr.length - 1 ; i >= 0 ; i--) {
            for(int j = i + 1 ; j <= arr.length - 1 ; j++) {   // decreasing elements from i to n - 1
                if(arr[i] > arr[j]) {
                    list[i] = Math.max(list[i], list[j] + 1);
                }
            }
        }

        // Print
        System.out.print("Longest Decreasing Subsequence: ");
        for(int i = 0 ; i < arr.length ; i++) {
            System.out.print(list[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int arr[] = { 1 , 5 , 4 , 6 }; 

        LIS(arr);
        LDS(arr);
    }
}
