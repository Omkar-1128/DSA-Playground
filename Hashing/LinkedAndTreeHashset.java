package Hashing;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class LinkedAndTreeHashset {
    public static void main(String[] args) {
        LinkedHashSet<String> cities = new LinkedHashSet<>();

        cities.add("Pune");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Nashik");

        HashSet<String> citiesHS = new HashSet<>();

        citiesHS.add("Pune");
        citiesHS.add("Delhi");
        citiesHS.add("Mumbai");
        citiesHS.add("Nashik");

        TreeSet<String> citiesTS = new TreeSet<>();

        citiesTS.add("Pune");
        citiesTS.add("Delhi");
        citiesTS.add("Mumbai");
        citiesTS.add("Nashik");

        System.out.println("Linked Hashset: " + cities);  // Insertion Order
        System.out.println("HashSet: " + citiesHS);  // Random Order
        System.out.println("TreeSet: " + citiesTS);  // Sorted Order
    }
}
