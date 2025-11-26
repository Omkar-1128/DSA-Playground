package Queues;

import java.util.*;

public class PriorityQueues {
    public static void main(String[] args) {
        System.out.println("Working of priority queue in Numbers: ");

        Queue<Integer> q1 = new LinkedList<>();

        q1.offer(4);
        q1.offer(7);
        q1.offer(1);
        q1.offer(9);
        q1.offer(3);

        System.out.print("Output for normal queue: ");
        while (!q1.isEmpty()) {
            System.out.print(q1.poll() + " ");
        }
        System.out.println();

        PriorityQueue<Integer> q = new PriorityQueue<>();

        q.offer(4);
        q.offer(7);
        q.offer(1);
        q.offer(9);
        q.offer(3);

        System.out.print("Output for priority queue: ");
        while (!q.isEmpty()) {
            System.out.print(q.poll() + " ");
        }
        System.out.println();


        // for Strings
        System.out.println("Working of priority queue in String: ");
        Queue<String> q3 = new LinkedList<>();

        q3.offer("A");
        q3.offer("E");
        q3.offer("C");
        q3.offer("B");
        q3.offer("D");

        System.out.print("Output for normal queue: ");
        while (!q3.isEmpty()) {
            System.out.print(q3.poll() + " ");
        }
        System.out.println();

        PriorityQueue<String> q4 = new PriorityQueue<>();

        q4.offer("A");
        q4.offer("E");
        q4.offer("C");
        q4.offer("B");
        q4.offer("D");

        System.out.print("Output for priority queue: ");
        while (!q4.isEmpty()) {
            System.out.print(q4.poll() + " ");
        }
    }
}
