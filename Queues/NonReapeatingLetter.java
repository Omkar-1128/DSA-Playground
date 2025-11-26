package Queues;

import java.util.LinkedList;
import java.util.Queue;

// first non repeating letter in a stream of charchter
public class NonReapeatingLetter {

    public static void PrintNonRepeating(String s) {
        int freq[] = new int[26];   // a - z
        Queue<Character> q = new LinkedList<>();

        for (int i = 0 ; i < s.length() ; i++) {
            char ch = s.charAt(i);

            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }

            if (q.isEmpty()) {
                System.out.print("-1 ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
    }
    public static void main(String[] args) {
        String str = "aabccxb";

        PrintNonRepeating(str);
    }
}
