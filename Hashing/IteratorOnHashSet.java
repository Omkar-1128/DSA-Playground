package Hashing;

import java.util.HashSet;
import java.util.Iterator;

public class IteratorOnHashSet {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Pune");
        cities.add("Mumbai");
        cities.add("Nashik");
        cities.add("Delhi");

        // Method 1: Using Iterator

        // Iterator it = cities.iterator();   // Iterator is Interface in java

        // while(it.hasNext()) {
        //     System.out.println(it.next());
        // }


        // Method 2: Using Advance Loop

        for(String city: cities) {
            System.out.println(city);
        }
    }
}
