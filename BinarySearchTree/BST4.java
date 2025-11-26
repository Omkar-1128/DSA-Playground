package BinarySearchTree;
import java.util.*;

public class BST4 {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }


    // Sorted Array to binary Search Tree
    public static Node createTree(Node root , int arr[] , int si , int ei) {  // O(n)
        if (si > ei) {
            return null;
        }

        int mid = (si + ei) / 2;
        root = new Node(arr[mid]);

        root.left = createTree(root.left, arr, si, mid - 1);
        root.right = createTree(root.right, arr, mid + 1, ei);

        return root;
    }

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    // convert BST to Balanced BST
        //         8                          8
        //        / \                        / \
        //       6   10         --->        5   11
        //      /     \                    / \  / \
        //     5       11                 3  6  10  12
        //    /         \
        //   3           12

    // 1] gets sorted array from the tree
    public static void getInOrder(Node root , ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        getInOrder(root.left , list);
        list.add(root.data);
        getInOrder(root.right , list);
    }

    public static Node BalanceTree(Node root) {
        // find Sorted Inorder
        ArrayList<Integer> list = new ArrayList<>();
        getInOrder(root, list);

        // SortedInorder -> Balanced Bst
        root = createTree(root, list.stream().mapToInt(i -> i).toArray(), 0, list.size() - 1);
        return root;
    }    

    // PreOrder 
    public static void PreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    
    public static void main(String[] args) {
        // int arr[] = {3 , 5 , 6 , 8 , 10 , 11 , 12};
        // Node root = null;

        // root = createTree(root, arr, 0, arr.length - 1);

        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        // InOrder(root);

        PreOrder(root);
        root = BalanceTree(root);
        System.out.println();
        PreOrder(root);
        
    }
}
