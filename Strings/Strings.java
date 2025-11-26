package Strings;
import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;

public class Strings {

    public static void PrintChar(String str) {
        for(int i = 0 ; i < str.length() ; i++) {
            System.out.print(str.charAt(i) + " ");
        }
        System.out.println();
    }

    // check the string is palindrom or not

    // public static boolean palindrom(String str) {
    //     for(int i = 0 ; i < str.length() ; i++) {
    //         if(str.charAt(i) != str.charAt(str.length() - i - 1)) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // shortest path 

    public static void shortestPath(String str) {
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < str.length(); i++) {
            if(str.charAt(i) == 'N') {
                y++;
            } else if(str.charAt(i) == 'S') {
                y--;
            } else if(str.charAt(i) == 'E') {
                x++;
            } else {
                x--;
            }
        }

        float displacement = (float) Math.sqrt((x * x) + (y * y));
        System.out.println("Shortest distance: " + displacement);
    }

    // Reverse the string

    public static void reverse(String str) {
        String newStr = "";
        for(int i = str.length() - 1 ; i >= 0 ; i--) {
            newStr+=str.charAt(i);
        }
        System.out.println(newStr);
    }

    // Make first letter of each word uppercase of string

    public static String ToUpperCase(String str) {
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1 ; i < str.length() ; i++) {
            if(str.charAt(i) == ' ') {
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
                i++;
            }

            sb.append(str.charAt(i));
        }

        return sb.toString();
    }

    public static String StringCompress(String str) {
        int n = str.length();
        StringBuilder sb = new StringBuilder(" ");
        for(int i = 0 ; i < n ; i++) {
            Integer count = 1;
            while (i < n - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count ++;
                i++;
            }
            sb.append(str.charAt(i));
            if(count > 1) {
                sb.append(count);
            }
        }

        return sb.toString();
    }

    // Count how many times lowercase vowels occurred in a String entered by the user.

    public static int ToLowerCase(String str) {
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++) {
            if(str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u') {
                count++;
            }
        }

        return count;
    }

    public static boolean Anagrams(String str1 , String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        char arr1[] = str1.toCharArray();
        char arr2[] = str2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        // boolean found = true;
        // for(int i = 0 ; i < arr1.length ; i++) {
        //     if(arr2[i] != arr2[i]) {
        //         found = false;
        //     }
        // }

        // if(found) {
        //     System.out.println("Both Strings are equal.");
        // }

        // return true;
        return Arrays.equals(arr1, arr2);
    }

    public static Boolean Anagrams2(String str1 , String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        HashMap <Character , Integer > map1 = new HashMap<>();
        HashMap <Character , Integer > map2 = new HashMap<>();

        for(int i = 0 ; i < str1.length() ; i++) {
            map1.put(str1.charAt(i), map1.getOrDefault(str1.charAt(i), 0) + 1);
            map2.put(str2.charAt(i), map2.getOrDefault(str2.charAt(i), 0) + 1);
        }

        return map1.equals(map2);
    }

    public static boolean OptimalAnagram(String s , String t) {
        if(s.length() != t.length()) {
            return false;
        }

        int[] Alpha = new int[26];
        

        for(int i = 0 ; i < s.length() ; i++) {
            Alpha[s.charAt(i) - 'a']++;
            Alpha[t.charAt(i) - 'a']--;
        }

        for(int i = 0 ; i < Alpha.length  ;i++) {
            if(Alpha[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        // String are immutable

        // String length

        // String str = "Lightning Ace";

        // System.out.println(str.length());

        // String Concatenation

        // String firstName = "Omkar";
        // String lastName = "Shelke";
        // String fullName = firstName + " " + lastName;

        // System.out.println(fullName);

        // PrintChar(fullName);

        // palindrom(lastName);

        // System.out.println(palindrom("onno"));

        // String str = "WNEENESENNN";
        // shortestPath(str);

        // Comarison of two string

        // String str1 = "Hello";
        // String str2 = "Hello";
        // String str3 = new String("Hello");

        // if(str1 == str2) {
        //     System.out.println("Equal");
        // } else {
        //     System.out.println("Not Equal");
        // }

        // if(str1 == str3) {
        //     System.out.println("Equal");
        // } else {
        //     System.out.println("Not Equal");
        // }

        // if(str1.equals(str3)) {   /// Always use .equal to compare the strings
        //     System.out.println("Equal");
        // } else {
        //     System.out.println("Not Equal");
        // }

        // SubString in java

        // String str = "HelloWorld";
        // System.out.println(str.substring(0 , 5));

        // reverse("Omkar");

        // String str1 = "apple";
        // String str2 = "banana";

        // System.out.println(str1.compareTo(str2));

        // String fruits[] = {"apple" , "banana" , "mango"};
        // String Largest = fruits[0];

        // for(int i = 1 ; i < fruits.length ; i++) {
        //     if(Largest.compareToIgnoreCase(fruits[i]) < 0) {
        //         Largest = fruits[i];
        //     } 
        // }

        // System.out.println(Largest);

        // String Builder

        // StringBuilder sb = new StringBuilder("");
        // for(char ch = 'a' ; ch <= 'z' ; ch++) {
        //     sb.append(ch);
        // }

        // System.out.println(sb);

        // String str = "hello, i am omkar shelke.";
        // System.out.println(ToUpperCase(str));

        // String str = "aaabbbcddd";
        // System.out.println(StringCompress(str));

        // Scanner sc = new Scanner(System.in);
        // String str = sc.nextLine();

        // System.out.println(ToLowerCase(str));

        // sc.close();

        // String str = "Omkar";
        // String str1 = "LightningAce";
        // String str2 = "Omkar";
        // System.out.println(str.equals(str1) + "  " + str.equals(str2));

        // String str = "LightningAce".replace("Ace", "Master");
        // System.out.println(str);

        String str1 = "nagaram";
        String str2 = "anagram";

        // System.out.println(Anagrams(str1 , str2));
        // System.out.println(Anagrams2(str1, str2));
        System.out.println(OptimalAnagram(str1, str2));

        // intern() method

        // String str1 = new String("Hello");
        // String str2 = str1.intern();
        // String str3 = "Hello";

        // System.out.println(str1 == str2);
        // System.out.println(str1 == str3);
        // System.out.println(str2 == str3);

        // String Buffer

        // StringBuffer sb = new StringBuffer("Lightning");
        // sb.append(" Ace");
        // sb.insert(0, "Java");

        // System.out.println(sb);
    }
}
