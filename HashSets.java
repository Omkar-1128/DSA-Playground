import java.util.HashSet;
import java.util.Iterator;

public class HashSets {
    public static void main(String[] args) {
        HashSet <Integer> Numbers = new HashSet<>();
        
        // add into Set
        Numbers.add(1);
        Numbers.add(2);
        Numbers.add(3);
        Numbers.add(1);

        // size of set

        System.out.println("Size of Numbers: " + Numbers.size());

        // Printing set

        System.out.println(Numbers);
        
        // Search - contains

        if(Numbers.contains(2)) {
            System.out.println("Contains 1");
        }
        if(!Numbers.contains(3)) {
            System.out.println("Not Contains");
        }

        // delete - remove

        Numbers.remove(1);
        if(!Numbers.contains(1)) {
            System.out.println("We deleted 1");
        }

        Iterator it = Numbers.iterator();

        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
