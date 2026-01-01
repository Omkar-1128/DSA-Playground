// Leetcode 208 
// Prefix Tree or Implement Trie

// class Trie {

//     static class Node {
//         Node[] children = new Node[26];
//         boolean eow = false;

//         public Node() {
//             for (int i = 0 ; i < 26 ; i++ ) {
//                 children[i] = null;
//             }
//         }
//     }

//     public Node root;

//     public Trie() {
//         root = new Node();
//     }

//     public void insert(String word) {
//         Node curr = root;

//         for(int level = 0 ; level < word.length() ; level++ ) {
//             int idx = word.charAt(level) - 'a';
//             if(curr.children[idx] == null) {
//                 curr.children[idx] = new Node();
//             }

//             curr = curr.children[idx];
//         }

//         curr.eow = true;
//     }

//     public boolean search(String word) {
//         Node curr = root;

//         for(int level = 0 ; level < word.length() ; level++ ) {
//             int idx = word.charAt(level) - 'a';
//             if(curr.children[idx] == null) {
//                 return false;
//             }

//             curr = curr.children[idx];
//         }

//         return curr.eow == true;
//     }

//     public boolean startsWith(String prefix) {
//         Node curr = root;

//         for(int level = 0 ; level < prefix.length() ; level++ ) {
//             int idx = prefix.charAt(level) - 'a';
//             if(curr.children[idx] == null) {
//                 return false;
//             }

//             curr = curr.children[idx];
//         }

//         return true;
//     }
// }

// /**
//  * Your Trie object will be instantiated and called as such:
//  * Trie obj = new Trie();
//  * obj.insert(word);
//  * boolean param_2 = obj.search(word);
//  * boolean param_3 = obj.startsWith(prefix);
//  */

// LeetCode Problem No. 720
// Longest Word in Dictionary

public class PQ {

    static class Node {
        Node[] children = new Node[26];
        boolean eow = false;

        public Node() {
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();
    public static StringBuilder largestAns = new StringBuilder();

    public static void insert(String word) {
        Node curr = root;

        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';

            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static void findLongestWord(Node curr, StringBuilder ans) {
        if (curr == null) {
            return;
        }

        if (curr != root && curr.eow == false) {
            return;
        }

        if (largestAns.length() == ans.length()) {
            if (largestAns.compareTo(ans) >= 0) {
                largestAns = new StringBuilder(ans);

            }
        } else if (largestAns.length() < ans.length()) {
            largestAns = new StringBuilder(ans);
        }

        for (int i = 0; i < 26; i++) {
            if (curr.children[i] != null) {
                ans.append((char) (i + 'a'));
                findLongestWord(curr.children[i], ans);
                ans.deleteCharAt(ans.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        String word[] = { "a", "banana", "app", "appl", "ap", "apply", "apple" };

        for (int i = 0; i < word.length; i++) {
            insert(word[i]);
        }

        StringBuilder ans = new StringBuilder();

        findLongestWord(root, ans);

        System.out.println(largestAns.toString());
    }
}