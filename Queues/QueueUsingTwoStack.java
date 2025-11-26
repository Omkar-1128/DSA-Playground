package Queues;

import java.util.*;

public class QueueUsingTwoStack {

    // Push O(n)
    static class Queue1 {
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public static void add(int data) {   // O(n)
            if (isEmpty()) {
                s1.push(data);
                return;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            s1.push(data);

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // remove
        public static int remove() {   // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return s1.pop();
        }

        // peek
        public static int peek() {   // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.peek();
        }
    }

    public static class Queue2 {
        public static Stack<Integer> s1 = new Stack<>();
        public static Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public static void add(int data) {   // O(1)
            s1.push(data);
        }

        // remove
        public static int remove() {   // O(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }

        // peek
        public static int peek() {   // O(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int val = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return val;
        }
        
    }

    public static void main(String[] args) {
        Queue1 q = new Queue1();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
