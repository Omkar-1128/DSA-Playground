package Queues;

import java.util.*;


public class stackandQueueUsingDeque {
    static class Stack {
        static Deque<Integer> deque = new LinkedList<>();

        // isEmpty
        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        // push
        public static void push(int data) {
            deque.addLast(data);
        }

        // pop
        public static int pop() {
            int val = deque.getLast();
            deque.removeLast();
            return val;
        }

        // peek 
        public static int peek() {
            return deque.getLast();
        }
    }

    static class Queue {
        static Deque<Integer> deque = new LinkedList<>();

        // isEmpty
        public static boolean isEmpty() {
            return deque.isEmpty();
        }

        // add
        public static void add(int data) {
            deque.addLast(data);
        }

        // remove 
        public static int remove() {
            return deque.removeFirst();
        }

        // peek
        public static int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String[] args) {
        // Stack s = new Stack();

        // s.push(1);
        // s.push(2);
        // s.push(3);

        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();
        // }


        Queue.add(1);
        Queue.add(2);
        Queue.add(3);

        while (!Queue.isEmpty()) {
            System.out.println(Queue.peek());
            Queue.remove();
        }
    }
}
