package Hashing;

import java.util.HashSet;
import java.util.HashMap;

public class PQ {

    // Count Distinct element
    public static int countDis(int arr[]) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            set.add(arr[i]);
        }

        return set.size();
    }

    // Union and intersection of two arrays
    public static void Union(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.print("Elements After Union : ");
        for (Integer el : set) {
            System.out.print(el + " ");
        }
        System.out.println();
    }

    public static void Intersection(int[] arr1, int[] arr2) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }

        System.out.print("Elements After Intersection: ");

        for (int i = 0; i < arr2.length; i++) {
            if (set.contains(arr2[i])) {
                System.out.print(arr2[i] + " ");
                set.remove(arr2[i]);
            }
        }

        System.out.println();
    }

    // Find Itinerary from a given list of tickets

    public static String findItinerary(HashMap<String, String> map) {
        HashMap<String, String> revMap = new HashMap<>();

        for (String key : map.keySet()) {
            revMap.put(map.get(key), key);
        }

        for (String key : map.keySet()) {
            if (!revMap.containsKey(key)) {
                return key;
            }
        }

        return null;
    }


    // Largest Sunarray With 0 Sum
//     class Solution {
//     int maxLength(int arr[]) {
//         // code here
//         HashMap<Integer , Integer> map = new HashMap<>();
//         map.put(0 , -1); // Sum , Index
//         int maxLength = 0;
//         int sum = 0;
        
//         for(int i = 0 ; i < arr.length ; i++) {
//             sum += arr[i];
            
//             if(map.containsKey(sum)) {
//                 maxLength = Math.max(maxLength , i - map.get(sum));
//             } else {
//                 map.put(sum , i);
//             }
//         }
        
        
//         return maxLength;
//     }
// }

// longest subarray with sum k

// class Solution {
//     public int subarray(int[] nums, int k) {
//         HashMap<Integer , Integer> map = new HashMap<>();
//         int sum = 0;
//         int length = 0;
//         map.put(0 , -1); // Sum , Index

//         for(int i = 0 ; i < nums.length ; i++) {
//             sum += nums[i];

//             if(map.containsKey(sum - k)) {
//                 length = Math.max(length , i - map.get(sum - k));
//             } else {
//                 map.put(sum , i);
//             }
//         }

//         return length;
//     }
// }

    public static void main(String[] args) {
        // int arr[] = {4 , 3 , 2 , 5 , 6 , 7 , 3 , 4 , 2 , 1};
        // System.out.println( "Total Distinct Element: " + countDis(arr));

        // int nums1[] = {4, 9, 5};
        // int nums2[] = {9, 4, 9, 8, 4};

        // Union(nums1 , nums2);

        // Intersection(nums1, nums2);

        HashMap<String, String> map = new HashMap<>();

        map.put("Chennai", "Bangalore");
        map.put("Bombay", "Delhi");
        map.put("Goa", "Chennai");
        map.put("Delhi", "Goa");

        String Start = findItinerary(map);
        System.out.print(Start);

        while (map.containsKey(Start)) {
            System.out.print(" -> " + map.get(Start));
            Start = map.get(Start);
        }
    }

}