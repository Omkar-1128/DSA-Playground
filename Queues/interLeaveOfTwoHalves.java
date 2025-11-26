package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class interLeaveOfTwoHalves {   // TC - O(n)  and SC - O(n)

    public static void InterLeave(Queue<Integer> q) {
        Queue<Integer> q2 = new LinkedList<>();

        int n = q.size();
        int i = 1;

        while (i <= n / 2) {
            q2.add(q.remove());
            i++;
        }

        while (!q2.isEmpty()) {
            q.add(q2.remove());
            q.add(q.remove());
        }
    }
    
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        InterLeave(q);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}
