package Hashing;

import java.util.HashSet;

public class Hashset {
    public static void main(String[] args) {
        
        HashSet<Integer> set = new HashSet<>();

        set.add(2);
        set.add(1);
        set.add(6);
        set.add(3);
        set.add(2);
        set.add(3);

        System.out.println(set);

        System.out.println("Size of set: " + set.size());

        set.remove(1);
        System.out.println(set.contains(1));

        System.out.println("Going to clear the set ...");
        set.clear();

        System.out.println("Size After Clear Operation: " + set.size());

        System.out.println("Is Set Empty: " + set.isEmpty());

    }
}
