package ArrayList;
import java.util.ArrayList;

public class ArrayLists {
    public static void main(String[] args) {

        // // Classname objectname = new Classname();
        // ArrayList<Integer> list = new ArrayList<>();
        // // ArrayList<String> list2 = new ArrayList<>();

        // // Operations of array list

        // // Add Opreration

        // list.add(1); // O(1)
        // list.add(2);
        // list.add(3);
        // list.add(4);

        // list.add(1 , 10); // O(n) // add at perticular index
        // System.out.println(list);

        // // Get Operation

        // int element = list.get(2); // O(1)
        // System.out.println(element);

        // // Remove Operation

        // list.remove(1);
        // System.out.println(list); // O(n)

        // // Set element at index operation

        // list.set(3 , 5); // O(n)

        // System.out.println(list);

        // // Contains element operation

        // System.out.println(list.contains(4)); // O(n)
        // System.out.println(list.contains(5));

        // size of array list

        // ArrayList<Integer> list = new ArrayList<>();

        // list.add(1);
        // list.add(2);
        // list.add(3);
        // list.add(4);
        // list.add(5);

        // int n = list.size();

        // System.out.println("Size of ArrayList: " + n);

        // for (int i = 0; i < list.size() ; i++) {
        // System.out.print( list.get(i) + " " );
        // }

        // System.out.println();

        // // Print reverse of ArrayList - O(n)

        // for (int i = list.size() - 1 ; i >= 0 ; i--) {
        // System.out.print(list.get(i) + " ");
        // }

        // Find Maximum number in array list

        ArrayList<Integer> list = new ArrayList<>();

        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);

        int n = list.size();
        int largest = list.get(0);
        for (int i = 1; i < n; i++) {
            largest = Math.max(largest , list.get(i));
        }

        System.out.println("Largest Element: " + largest);
    }
}
