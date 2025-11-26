package Heaps;

import java.util.PriorityQueue;

public class PQ {
    // 973. K Closest Points to Origin
    // Given an array of points where points[i] = [xi, yi] represents a point on the
    // X-Y plane and an integer k, return the k closest points to the origin (0, 0).
    // The distance between two points on the X-Y plane is the Euclidean distance
    // (i.e., √(x1 - x2)2 + (y1 - y2)2).
    // You may return the answer in any order. The answer is guaranteed to be unique
    // (except for the order that it is in).

    static class Point implements Comparable<Point> {
        int x;
        int y;
        int dist;

        public Point(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Point p) {
            return this.dist - p.dist;
        }
    }

    public static int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>();
        int ans[][] = new int[k][2];

        for (int i = 0; i < points.length; i++) {
            int dist = (points[i][0] * points[i][0]) + (points[i][1] * points[i][1]);
            pq.add(new Point(points[i][0], points[i][1], dist));
        }

        for (int i = 0; i < k; i++) {
            ans[i][0] = pq.peek().x;
            ans[i][1] = pq.peek().y;
            pq.remove();
        }

        return ans;
    }

    // Connect n ropes with minimum cost
    // Last Updated : 23 Jul, 2025
    // Given an array arr[] of rope lengths, connect all ropes into a single rope
    // with the minimum total cost. The cost to connect two ropes is the sum of
    // their lengths.
    // Examples:
    // Input: arr[] = [4, 3, 2, 6]
    // Output: 29

    public static void ConnectRopes(int arr[]) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }

        int totalCost = 0;

        while (pq.size() > 1) {
            int cost = pq.remove() + pq.remove();
            totalCost += cost;
            pq.add(cost);
        }

        System.out.println("Cost for to connect " + arr.length + " Ropes -> " + totalCost);
    }

    // 1337. The K Weakest Rows in a Matrix
    // Input: mat =
    // [[1,1,0,0,0],
    // [1,1,1,1,0],
    // [1,0,0,0,0],
    // [1,1,0,0,0],
    // [1,1,1,1,1]],
    // k = 3
    // Output: [2,0,3]
    // Explanation:
    // The number of soldiers in each row is:
    // - Row 0: 2
    // - Row 1: 4
    // - Row 2: 1
    // - Row 3: 2
    // - Row 4: 5
    // The rows ordered from weakest to strongest are [2,0,3,1,4].

    class Solution {
        class Info implements Comparable<Info> {
            int row;
            int soldiers;

            Info(int row, int soldiers) {
                this.row = row;
                this.soldiers = soldiers;
            }

            @Override
            public int compareTo(Info a) {
                if (this.soldiers == a.soldiers) {
                    return this.row - a.row;
                }
                return this.soldiers - a.soldiers;
            }
        }

        public int[] kWeakestRows(int[][] mat, int k) {
            PriorityQueue<Info> pq = new PriorityQueue<>();
            int ans[] = new int[k];

            for (int i = 0; i < mat.length; i++) {
                int j = 0;
                int totalSoldiers = 0;
                while (j < mat[i].length && mat[i][j] == 1) {
                    totalSoldiers += 1;
                    j++;
                }

                pq.add(new Info(i, totalSoldiers));
            }
            for (int i = 0; i < k; i++) {
                ans[i] = pq.peek().row;
                pq.remove();
            }

            return ans;
        }

    }

    // 239. Sliding Window Maximum

    // class Solution {
    //     class Info implements Comparable<Info> {
    //         int idx;
    //         int val;

    //         Info(int idx, int val) {
    //             this.idx = idx;
    //             this.val = val;
    //         }

    //         @Override
    //         public int compareTo(Info s) {
    //             return s.val - this.val;
    //         }
    //     }

    //     public int[] maxSlidingWindow(int[] nums, int k) {
    //         int n = nums.length;
    //         int ans[] = new int[n - k + 1];
    //         PriorityQueue<Info> pq = new PriorityQueue<>();

    //         for (int i = 0; i < k; i++) {
    //             pq.add(new Info(i, nums[i]));
    //         }
    //         int j = 0;
    //         ans[j++] = pq.peek().val;

    //         for (int i = k; i < n; i++) {
    //             while (!pq.isEmpty() && pq.peek().idx <= i - k) {
    //                 pq.remove();
    //             }
    //             pq.add(new Info(i, nums[i]));
    //             ans[j++] = pq.peek().val;
    //         }

    //         return ans;
    //     }
    // }

    public static void main(String[] args) {
        // int pts[][] = {{3 , 3} , {5 , -1} , {-2 , 4}};
        // int k = 2;
        // int ans[][] = kClosest(pts , k);

        // for (int i = 0 ; i < ans.length ; i++) {
        // System.out.println(ans[i][0] + " " + ans[i][1]);
        // }

        int ropes[] = { 4, 3, 2, 6 };
        ConnectRopes(ropes);
    }
}
