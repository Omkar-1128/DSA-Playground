package Heaps;
import java.util.PriorityQueue;

public class PriorityQueues {

    // Priority queues in classes 
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        Student (String name , int rank) {
            this.name = name;
            this.rank = rank;
        }

        @Override
        public int compareTo(Student s) {
            return this.rank - s.rank;
        }
    }
    public static void main(String[] args) {
        // // Comparator is a Interface used to Compare the elements
        // // reverseOrder is function which give reverse logic
        // // basically it comapares the elements and give element in descending order
        // PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        // // add - O(logn)
        // pq.add(8);
        // pq.add(1);
        // pq.add(5);
        // pq.add(3);

        // while (!pq.isEmpty()) {
        //     System.out.println(pq.peek());  // peek - O(1)
        //     pq.remove();  // remove - O(logn)
        // }

        // Priority Queue in classes
        PriorityQueue<Student> pq = new PriorityQueue<>();
        // PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder());

        pq.add(new Student("A", 5));
        pq.add(new Student("B", 12));
        pq.add(new Student("C", 1));
        pq.add(new Student("D", 7));

        while (!pq.isEmpty()) {
            System.out.println(pq.peek().name + " -> " + pq.peek().rank);
            pq.remove();
        }
    }
}
