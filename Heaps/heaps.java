package Heaps;
import java.util.*;

//                                          Min Heap

public class heaps {
    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();
        
        // Add Operation
        public void add(int data) {  // O(logn)
            // add at last index
            arr.add(data);   // O(1)

            int x = arr.size() - 1; // child index
            int par = (x - 1) / 2;  // Parent index

            while (arr.get(par) > arr.get(x)) {  // O(logn)
                int temp = arr.get(par);
                arr.set(par, arr.get(x));
                arr.set(x , temp);

                x = par;
                par = (x - 1) / 2;
            }
        }

        // Peek Operation
        public int peek() {
            return arr.get(0);
        }

        private void Heapify(int i) {
            int minIdx = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;

            if (arr.size() > left && arr.get(minIdx) > arr.get(left)) {
                minIdx = left;
            }

            if (arr.size() > right && arr.get(minIdx) > arr.get(right)) {
                minIdx = right;
            }

            // Swap
            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i , arr.get(minIdx));
                arr.set(minIdx, temp);

                Heapify(minIdx);
            }
        }

        // Remove Operation
        public int remove() {
            int data = arr.get(0);

            // Step 1:- swap between 1st and last index of array
            int temp = arr.get(0);
            arr.set(0 , arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Step 2:- remove the last index element from the array
            arr.remove(arr.size() - 1);

            // Step 3 :- Heapify
            Heapify(0);

            return data;
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }
    }

    public static void main(String[] args) {
        Heap h = new Heap();

        h.add(2);
        h.add(3);
        h.add(4);
        h.add(5);
        h.add(10);
        h.add(1);

        while (!h.isEmpty()) {  // Heap Sort
            System.out.print(h.peek() + " ");
            h.remove();
        }
    }
}
