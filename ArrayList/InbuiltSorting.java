package ArrayList;

import java.util.ArrayList;
import java.util.Collections;

public class InbuiltSorting {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        // Time complexity of inbuilt sort - O(nlogn)
        System.out.println(list);
        Collections.sort(list); // sorting in ascending order
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder()); // Sorting in reverse order
        System.out.println(list);

        // Collection.reverseOrder() <- logic Functions also know Comparator
        // Used to define the sorting logic in the code
    }
}
