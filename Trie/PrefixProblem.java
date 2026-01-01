// package Trie;

public class PrefixProblem {
    static class Node {
        Node children[] = new Node[26];
        boolean eow = false;
        int freq;

        public Node() {
            for(int i= 0 ; i < 26 ; i++) {
                children[i] = null;
            }

            freq = 1;
        }
    }

    public static Node root = new Node();

    public static void insert(String word) {
        Node curr = root;

        for(int level = 0 ; level < word.length() ; level++) {
            int idx = word.charAt(level) - 'a';

            if(curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else {
                curr.children[idx].freq++;
            }

            curr = curr.children[idx];
        }

        curr.eow = true;
    }

    public static String Search(String key) {
        Node curr = root;
        StringBuilder ans = new StringBuilder("");

        for(int level = 0 ; level < key.length() ; level++) {
            int idx = key.charAt(level) - 'a';

            if(curr.children[idx] == null) {
                return "null";
            }

            if(curr.children[idx].freq == 1) {
                ans.append((char) (idx + 'a'));
                return ans.toString();
            } else {
                ans.append((char) (idx + 'a'));
            }
            curr = curr.children[idx];
        }

        return ans.toString();
    }

    // Recursion Logic to get output in alphabetical order

    public static void findPrefix(Node root , String ans) {
        if(root == null) {
            return;
        }

        if(root.freq == 1) {
            System.out.print(ans + " ");
            return;
        }

        for(int i = 0 ; i < 26 ; i++) {
            if(root.children[i] != null) {
                findPrefix(root.children[i], ans +( (char) (i + 'a') ));
            }
        }
    }

    public static void main(String[] args) {
        String arr[] = {"zebra" , "dog" , "duck" , "dove"};

        for(int i = 0 ; i < arr.length ; i++) {
            insert(arr[i]);
        }

        root.freq = -1;

        String ans[] = new String[arr.length];

        for (int i = 0 ; i < arr.length ; i++) {
            ans[i] = Search(arr[i]);
        }

        System.out.print("Answer using Search: ");
        for(int i = 0 ; i < ans.length ; i++) {
            System.out.print(ans[i] + " ");
        }

        System.out.println();

        System.out.print("Answer using findPrefix: ");
        findPrefix(root, "");

    }
}
