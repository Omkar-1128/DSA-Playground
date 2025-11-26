package GreedyAlgorithm;
import java.util.*;

public class FractionalKnapsack {
    public static void main(String[] args) {
        int profit[] = {60 , 100 , 120};
        int weight[] = {10 , 20 , 30};
        int W = 50;
        int capacity = W;
        int items = 3;
        int maxProfit = 0;

        int profitByWeight[][] = new int[items][2];  // 2 -> [items][0]index and [items][1]ratio

        for (int i = 0 ; i < items ; i++) {
            profitByWeight[i][0] = i;
            profitByWeight[i][1] = profit[i] / weight[i];   // ratio
        }   

        // Sort in decending order -> using caparator
        Arrays.sort(profitByWeight , (a , b) -> b[1] - a[1]);

        int j = 0;
        for (int i = 0 ; i < items ; i++) {
            j = profitByWeight[i][0];  // j is index with maximum ratio
            if (weight[j] <= capacity) {  // Include Full Item
                capacity -= weight[j];
                maxProfit += profit[j];
            } else {   // Include Fractional 
                maxProfit += profitByWeight[i][1] * capacity;
                capacity = 0;
                break;
            }
        }
        
        System.out.println("Maximum Profit -> " + maxProfit);
        System.out.println("Maximum Weight -> " + W);
    }
}



// tc:- O(n^2)