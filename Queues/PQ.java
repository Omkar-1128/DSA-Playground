package Queues;

import java.util.*;

public class PQ {
    // Reversing the first K elements of a Queue
    // We have an integer k and a queue of integers, we need to reverse the order of
    // the first k
    // elements of the queue, leaving the other elements in the same relative order.
    // Sample Input 1 : Q = [10, 20, 30, 40, 50, 60, 70, 80, 90, 100] ,k=5
    // Sample Output 1 : Q = [50, 40, 30, 20, 10, 60, 70, 80, 90, 100]

    public static void reverse(Queue<Integer> q, int k) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q2 = new LinkedList<>();

        int i = 1;
        while (i <= k) {
            s.push(q.remove());
            i++;
        }

        while (!q.isEmpty()) {
            q2.add(q.remove());
        }

        while (!s.isEmpty()) {
            q.add(s.pop());
        }

        while (!q2.isEmpty()) {
            q.add(q2.remove());
        }
    }

    // Question 5 :
    // Maximum of all subarrays of size k
    // We have an array arr[] of size N and an integer K. Find the maximum for each
    // and every
    // contiguous subarray of size K.
    // Sample Input 1 : N=9, K=3 arr= 1 2 3 1 4 5 2 3 6
    // Sample Output 1 : 3 3 4 5 5 5 6

    // public static void maximumSubarray(int n , int k , int[] arr) { /// TLE Error
    // // TC - O(n + k)
    // for (int i = 0 ; i <= n - k ; i++) {
    // Queue<Integer> q = new LinkedList<>();
    // int j = i;
    // while (j < i + k) {
    // q.add(arr[j]);
    // j++;
    // }

    // int temp = q.remove();
    // while (!q.isEmpty()) {
    // if (q.peek() > temp) {
    // temp = q.peek();
    // }
    // q.remove();
    // }

    // System.out.print(temp + " ");
    // }
    // }

    // Using Deque
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            int n = nums.length;
            int ans[] = new int[n - k + 1];
            Deque<Integer> deque = new LinkedList<>();
            int current_win = 0;

            for (int i = 0; i < k; i++) {
                while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                    deque.removeLast();
                }
                deque.add(i);
            }
            ans[current_win++] = nums[deque.getFirst()];

            for (int i = k; i < n; i++) {
                while (!deque.isEmpty() && nums[deque.getLast()] < nums[i]) {
                    deque.removeLast();
                }

                while (!deque.isEmpty() && deque.getFirst() < i - k + 1) {
                    deque.removeFirst();
                }

                deque.add(i);
                ans[current_win++] = nums[deque.getFirst()];
            }

            return ans;
        }
    }

    // Generate Binary Numbers
    // Given a number N. The task is to generate and print all binary numbers with decimal values from
    // 1 to N

    public static void GenerateBinaryNumbers(int n) {
        Queue<String> q = new LinkedList<>();
        q.add("1");
        
        while (n-- > 0) {
            String s1 = q.peek();
            q.remove();
            System.out.print(s1 + " ");
            String s2 = s1;
            q.add(s1 + "0");
            q.add(s2 + "1");
        }
    }

    // Connect n ropes with minimum cost
    // Given are N ropes of different lengths, the task is to connect these ropes into one rope with
    // minimum cost, such that the cost to connect two ropes is equal to the sum of their lengths.
    // Sample Input 1 : N = 4, arr = [4 3 2 6]
    // Sample Output 1 : 29

    public static int minCost(int arr[] , int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0 ; i < n ; i++) {
            pq.offer(arr[i]);
        }

        int res = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
    
            res += first + second;
            pq.offer(first + second);
        }

        return res;
    }

    // Job Sequencing We have an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
    // It is also given that every job takes a single unit of time, so the minimum possible deadline for any job is 1.
    // Maximize the total profit if only one job can be scheduled at a time.

    static class job {
        String jobid;
        int Deadline;
        int Profit;

        public job (String jobid , int Deadline , int Profit) {
            this.jobid = jobid;
            this.Deadline = Deadline;
            this.Profit = Profit;
        }
    }


    public static void main(String[] args) {
        // Queue<Integer> q = new LinkedList<>();

        // q.add(10);
        // q.add(20);
        // q.add(30);
        // q.add(40);
        // q.add(50);
        // q.add(60);
        // q.add(70);
        // q.add(80);
        // q.add(90);
        // q.add(100);

        // int k = 5;

        // reverse(q, k);

        // System.out.print(q);

        // int arr[] = { 1, 2, 3, 1, 4, 5, 2, 3, 6 };
        // int k = 3;
        // int n = 9;
        
        // Solution sol = new PQ().new Solution();
        // int ans[] = sol.maxSlidingWindow(arr , k);

        // for (int i = 0 ; i < ans.length ; i++) {
        //     System.out.print(ans[i] + " ");
        // }

        // Generate Binary Numebr
        // GenerateBinaryNumbers(5);

        // int n = 4;
        // int arr[] = { 4 , 3 , 2 , 6 };

        // System.out.println("Total cost of connecting " + n + " Ropes is: " + minCost(arr, n));



        job jobs[] = {
            new job("a" , 4 , 20),
            new job("b", 1, 10),
            new job("c", 1, 40),
            new job("d", 1, 30)
        };

        Arrays.sort(jobs, (j1, j2) -> j2.Profit - j1.Profit);

        int maxDeadline = 0;
        for (job job : jobs) {
            maxDeadline = Math.max(maxDeadline, job.Deadline);
        }

        String arr[] = new String[maxDeadline + 1];
        Arrays.fill(arr, "");

        Queue<String> q = new LinkedList<>();

        for (job job : jobs) {
            for (int i = job.Deadline ; i > 0 ; i--) {
                if (arr[i].equals("")) {
                    arr[i] = job.jobid;
                    q.add(job.jobid);
                    break;
                }
            }
        }

        System.out.print("Scheduled Jobs: ");
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
    }
}
