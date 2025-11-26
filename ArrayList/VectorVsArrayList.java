package ArrayList;

import java.util.*;

// ArrayList → Not synchronized (faster, used in single-threaded programs).

// Vector → Synchronized (thread-safe but slower).

// List<String> list = Collections.synchronizedList(new ArrayList<String>());
// Now all operations on list are thread-safe (like Vector).

public class VectorVsArrayList {
    public static void main(String[] args) {

        // Vector

        long start = System.currentTimeMillis();
        Vector<Integer> vector = new Vector<>();

        int size = 10000000;

        for (int i = 0; i < size; i++) {
            vector.add(i);
        }

        long end = System.currentTimeMillis();

        System.out.println("Vector Time: " + (end - start) + "ms");

        // ArrayList

        start = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        end = System.currentTimeMillis();

        System.out.println("ArrayList Time: " + (end - start) + "ms");

        // Approximate timings
        // Vector Time: 181ms
        // ArrayList Time: 138ms
    }
}
