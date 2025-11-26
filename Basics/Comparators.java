package Basics;
import java.util.*;

public class Comparators {
    public interface Demo {
        void method1();
    }

    static class Demo2 {
        int id;
        String name;

        public Demo2(int id , String name) {
            this.id = id;
            this.name = name;
        } 
    }

    public static void main(String[] args) {
        // lambda Expression 
        // Demo obj = () -> {
        //     System.out.println("This is method 1");
        // };

        // obj.method1();

        // Comparators for lists
        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(3);
        // list.add(7);
        // list.add(1);
        // list.add(5);
        // list.add(0);

        // Collections.sort(list)  // Sorting in acending order
        // Collections.sort(list , (a , b) -> b - a);  // Sorting in decending order
        // System.out.println(list);

        // Comparators for objects
        Demo2 d1 = new Demo2(3, "a");
        Demo2 d2 = new Demo2(4, "d");
        Demo2 d3 = new Demo2(2, "b");
        Demo2 d4 = new Demo2(1, "c");

        ArrayList<Demo2> list = new ArrayList<>();
        list.add(d1);
        list.add(d2);
        list.add(d3);
        list.add(d4);

        Collections.sort(list , (a , b) -> b.id - a.id);  // Sorting in Decending order
        // Collections.sort(list , (a , b) -> a.id - b.id);   // Sorting in acending order
        for (Demo2 Slist : list) {
            System.out.println(Slist.id + "  " + Slist.name);
        }
    }
}
