package Heaps;
import java.util.*;

//                                              Max heap

// Same code as min heap  just 3 changes 
public class MaxHeap {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // add Operation
        public void add(int data) {
            arr.add(data);

            int x = arr.size() - 1;
            int par = (x - 1) / 2;

            while (arr.get(par) < arr.get(x)) {// first change parent should greater than child in max Heap
                int temp = arr.get(x);
                arr.set(x , arr.get(par));
                arr.set(par, temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // peek Operation
        public int peek() {
            return arr.get(0);
        }

        // Heapify Function
        private void Heapify(int i) {
            int maxIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            // if the left and right index values are greater than the root then swap 

            if (left < arr.size() && arr.get(maxIdx) < arr.get(left)) {  // Second Changes 
                maxIdx = left;
            }

            if (right < arr.size() && arr.get(maxIdx) < arr.get(right)) {  // Third Change
                maxIdx = right; 
            }

            if (maxIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(maxIdx));
                arr.set(maxIdx, temp);

                Heapify(maxIdx);  // If the remaining tree becomes unbalanced due to swap then this function automaically fix it
            }
        }

        // remove Opration
        public int remove() {
            int data = arr.get(0);

            // Step 1 replace fisrt index element with last index element   
            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2 Remove the Last index element 
            arr.remove(arr.size() - 1);

            // Step 2 Heapify
            Heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap pq = new Heap();

        pq.add(5);
        pq.add(1);
        pq.add(9);
        pq.add(4);
        pq.add(2);

        while (!pq.isEmpty()) {
            System.out.print(pq.peek() + " ");
            pq.remove();
        }
    }
}
