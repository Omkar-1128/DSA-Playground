package GreedyAlgorithm;

import java.util.*;

public class JobSequencing {

    static class job {
        int profit;
        int deadline;
        String id;

        public job(String id ,int deadline , int profit) {
            this.profit = profit;
            this.deadline = deadline;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        job jobs[] = {
            new job("a" , 4, 20),
            new job("b" ,1, 10),
            new job("c" , 1, 40),
            new job("d" , 1, 30)
        };

        //Descending order Sorting according of profit
        Arrays.sort(jobs , (a , b) -> b.profit - a.profit);

        int time = 0;
        int maxProfit = 0;
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0 ; i < jobs.length ; i++) {
            if (jobs[i].deadline > time) {
                ans.add(jobs[i].id);
                maxProfit += jobs[i].profit;
                time++;
            }
        }

        System.out.println("Maximum Jobs -> " + ans.size());
        System.out.println("Jobs Sequence -> " + ans);
        System.out.println("Maximum Profit -> " + maxProfit);
        
    }
}
