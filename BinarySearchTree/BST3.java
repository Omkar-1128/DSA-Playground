package BinarySearchTree;

import java.util.ArrayList;

public class BST3 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node Insert(int val , Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data < val) {
            root.right = Insert(val, root.right);
        } else {
            root.left = Insert(val, root.left);
        }

        return root;
    }

    public static void InOrder(Node root , ArrayList<Integer> list) {
        if (root == null) {
            return;
        }

        InOrder(root.left , list);
        list.add(root.data);
        InOrder(root.right , list);
    }

    // Check the tree is Valid or Not

    // Approch 1
    public static boolean IsValid(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        InOrder(root, list);

        for (int i = 1 ; i < list.size() ; i++) {
            if (list.get(i - 1) > list.get(i)) {
                return false;
            }
        }

        return true;
    }

    // Approch 2
    public static boolean IsValid2(Node root , Node min , Node max) {
        if (root == null) {
            return true;
        }

        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
        }

        return IsValid2(root.left , min , root) && IsValid2(root.right , root , max);
    }

    // Mirror a Binary Search Tree
    public static Node mirror(Node root) {
        if (root == null) {
            return null;
        }

        Node LeftS = mirror(root.left);
        Node RightS = mirror(root.right);

        root.left = RightS;
        root.right = LeftS;

        return root;
    }

    // Preorder
    public static void PreOrder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data +" ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static void main(String[] args) {
        int values[] = {3 , 2 , 1 , 4 , 5};
        // int values[] = {1 , 1 , 1};
        Node newNode = null;
        for (int i = 0 ; i < values.length ; i++) {
            newNode = Insert(values[i], newNode);
        }

        // if (IsValid2(newNode , null , null)) {
        //     System.out.println("Given BST is Valid");
        // } else {
        //     System.out.println("Given BST is Not Valid");
        // }

        PreOrder(newNode);
        System.out.println();
        mirror(newNode);
        PreOrder(newNode);
    }
}
