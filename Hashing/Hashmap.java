package Hashing;

import java.util.HashMap;
import java.util.Set;
import java.util.Map;

public class Hashmap {
    public static void main(String[] args) {
        
        HashMap<String , Integer> map = new HashMap<>();

        // Put fucntion // TC :- O(1)
        map.put("India" , 100);
        map.put("China" , 150);
        map.put("Nepal" , 10);
        map.put("India" , 110);  // updates value if key alreay present

        System.out.println(map);

        // Get function // TC :- O(1)
        int Population = map.get("India");

        System.out.println(Population);
        System.out.println(map.get("Indonesia"));  // return null if value is not present

        // containsKey // TC :- O(1)

        System.out.println(map.containsKey("India"));

        // remove // TC :- O(1)

        System.out.println(map.remove("India"));
        System.out.println(map.remove("Indonesia"));
        System.out.println(map);


        // size of map
        System.out.println(map.size());

        // map.clear();  // clear the map
        // System.out.println(map);

        // Check map is empty or not
        System.out.println(map.isEmpty());

        // Iteration on map
        // using key set
        // Set<String> keys = map.keySet();
        // System.out.println(keys);

        // for (String k : keys) {
        //     System.out.println("Key = " + k + " , Value = " + map.get(k));
        // }

        // using entryset
        Set<Map.Entry<String , Integer>> data = map.entrySet();

        for (Map.Entry<String,Integer> entry : data) {
            System.out.println("Key = " + entry.getKey() +  " , Value = " + entry.getValue());
        }

    }
}
