package Hashing;

import java.util.TreeMap;
import java.util.HashMap;

public class Treemap {
    public static void main(String[] args) {
        TreeMap<String , Integer> TM = new TreeMap<>();

        TM.put("China" , 150);
        TM.put("US" , 50);
        TM.put("Nepal" , 10);
        TM.put("India" , 100);

        HashMap<String , Integer> HM = new HashMap<>();

        HM.put("China" , 150);
        HM.put("US" , 50);
        HM.put("Nepal" , 10);
        HM.put("India" , 100);

        System.out.println(TM);
        System.out.println(HM);
    }
}
