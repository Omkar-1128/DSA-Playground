package LinkList;

import java.util.LinkedList;   // Java collection framework
 
public class InbuiltFunctions {
    public static void main(String[] args) {
        // Create LinkList
        LinkedList<Integer> Ll = new LinkedList<>();

        // add in LinkList 
        Ll.addLast(1);
        Ll.addLast(2);
        Ll.addFirst(0);

        System.out.println(Ll); // print Linklist

        // remove 
        // Ll.removeFirst();
        Ll.remove(1);
        Ll.removeLast();
        System.out.println(Ll);
    }
}
