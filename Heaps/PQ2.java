package Heaps;

import java.util.*;

public class PQ2 {

    // 703. Kth Largest Element in a Stream
    public static void KthLargest(int stream[], int k) {
        int n = stream.length;
        int ans[] = new int[n - k + 1];
        int temp[] = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            pq.add(stream[i]);
        }
        int j = 0;
        int m = 0;
        while (!pq.isEmpty()) {
            temp[j++] = pq.remove();
        }

        ans[m++] = temp[temp.length - 1];

        for (j = temp.length - 1; j >= 0; j--) {
            pq.add(temp[j]);
        }

        for (int i = k; i < n; i++) {
            pq.add(stream[i]);

            for (j = 0; j < k; j++) {
                temp[j++] = pq.remove();
            }

            ans[m++] = temp[k - 1];

            for (j = k - 1; j >= 0; j--) {
                pq.add(temp[j]);
            }
        }

        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    // 23. Merge k Sorted Lists

    // class Solution {
    //     public ListNode mergeKLists(ListNode[] lists) {
    //         PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    //         ListNode ans = new ListNode(0);
    //         ListNode currTail = ans;

    //         for (int i = 0; i < lists.length; i++) {
    //             if (lists[i] != null) {
    //                 pq.add(lists[i]);
    //             }
    //         }

    //         while (!pq.isEmpty()) {
    //             ListNode curr = pq.poll();

    //             currTail.next = curr;
    //             currTail = currTail.next;

    //             if (curr.next != null) {
    //                 curr = curr.next;
    //                 pq.add(curr);
    //             }
    //         }

    //         return ans.next;
    //     }
    // }

    public static void main(String[] args) {
        int stream[] = { 10, 20, 11, 70, 50, 40, 100, 5 };
        int k = 3;

        KthLargest(stream, k);
    }

}
