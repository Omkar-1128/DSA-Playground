package Queues;

public class queuesUsingArray {
    static class Queues {
        static int arr[];
        static int size;
        static int rear;    

        public Queues (int n) {
            this.size = n;
            this.rear = -1;
            this.arr = new int[n];
        }

        // isEmpty
        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) {   // O(1)
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear++;
            arr[rear] = data;
        }

        // remove 
        public static int remove() {    // O(n)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];
            for (int i = 0 ; i < rear ; i++) {
                arr[i] = arr[i + 1];
            }

            rear--;

            return front;
        }

        // peek
        public static int peek() {     // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[0];
        }
    }

    static class CircularQueues {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueues(int n) {
            this.size = n;
            arr = new int[n];
            rear = -1;
            front = -1;
        }

        // isEmpty
        public static boolean isEmpty() {
            return front == -1 && rear == -1;
        }

        // isFull
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            //add first element
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            
            int result = arr[front];
            // if the last el deleted
            if (front == rear) {
                front = rear = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            return arr[front];
        }
        
    }

    public static void main(String[] args) {
        // Queues q = new Queues(5);

        // q.add(1);
        // q.add(2);
        // q.add(3);

        // while (!q.isEmpty()) {
        //     System.out.println(q.peek());
        //     q.remove();
        // }       

        CircularQueues q = new CircularQueues(3);

        q.add(1);
        q.add(2);
        q.add(3);  // 1 , 2 , 3

        System.out.println(q.remove());
        q.add(4);  // 4 , 2 , 3

        System.out.println(q.remove());
        q.add(5); // 4 , 5 , 3

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

       
    }
}
