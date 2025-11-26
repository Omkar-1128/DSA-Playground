package Queues;

public class queuesUsingLinkedList {
    static class Node {
        public int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }



    public static class Queue {
        public static Node Head = null;
        public static Node Tail = null;

        // is Empty
        public static boolean isEmpty() {
            return Head == null && Tail == null;
        }

        // add
        public static void add(int data) {   // O(1)
            Node newNode = new Node(data);
            if (isEmpty()) {
                Head = Tail = newNode;
                return;
            }

            Tail.next = newNode;

            Tail = newNode;
        }

        //remove
        public static int remove() {   // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            
            int front = Head.data;
            if (Head == Tail) {
                Head = Tail = null;
                return front;
            }

            Head = Head.next;

            return front;
        }

        // peek 
        public static int peek() {   // O(1)
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return Head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
