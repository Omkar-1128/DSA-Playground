package Hashing;

import java.util.LinkedHashMap;
import java.util.HashMap;

public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String , Integer> LHM = new LinkedHashMap<>();

        LHM.put("India" , 110);
        LHM.put("China" , 150);
        LHM.put("Nepal" , 20);
        LHM.put("US" , 50);

        HashMap<String , Integer> HM = new HashMap<>();

        HM.put("India" , 110);
        HM.put("China" , 150);
        HM.put("Nepal" , 20);
        HM.put("US" , 50);

        System.out.println(LHM);  // Gives same ordered output as put in the hashmap
        System.out.println(HM);
    }
}
