package Queues;

import java.util.*;

public class JCF {
    public static void main(String[] args) {
        // Queue
    
        // Queue<Integer> q = new LinkedList<>(); 
        // Queue<Integer> q = new ArrayDeque<>();

        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }

        // Deque

        Deque<Integer> deque = new LinkedList<>();

        deque.addFirst(1); // 1
        deque.addFirst(2);  // 2 1
        deque.addLast(3);  // 2 1 3
        deque.addLast(4);  // 2 1 3 4 
        System.out.println(deque);

        System.out.println("First Element = " + deque.getFirst());  // 2
        System.out.println("Last Element = " + deque.getLast());  // 4

        deque.removeFirst();
        System.out.println(deque);   // 1 3 4
 
        deque.removeLast();
        System.out.println(deque);  // 1 3

    }
}
