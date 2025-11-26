package GreedyAlgorithm;

import java.util.*;

public class ActivitySelection {   // TC = O(n)   // with sorting O(nlogn)
    public static void main(String[] args) {
        int start[] = {1 , 3 , 0 , 5 , 8 , 5};
        int end[] = {2 , 4 , 6 ,7 , 9 , 9};

        // Sorting 
        int activities[][] = new int[start.length][3];

        for (int i = 0 ; i < end.length ; i++) {
            activities[i][0] = i;
            activities[i][1] = start[i];
            activities[i][2] = end[i];
        }

        // lambda function - short form
        Arrays.sort(activities , Comparator.comparingDouble(o -> o[2]));

        // end time basis sorted
        ArrayList<Integer> ans = new ArrayList<>();
        int maxAct = 0;

        // 1st activity
        maxAct = 1;
        ans.add(activities[0][0]);
        int lastEnd = activities[0][2];   // end[i]

        for (int i = 1 ; i < end.length ; i++) {
            if (activities[i][1] >= lastEnd) {  // start[i] >= lastEnd
                // Activity select
                maxAct++;
                ans.add(activities[i][0]);
                lastEnd = activities[i][2];
            }
        }

        System.out.println("Maximum activities: " + maxAct);

        for (int i = 0 ; i < ans.size() ; i++) {
            System.out.print("A" + ans.get(activities[i][0]) + " ");
        }
    } 
}
