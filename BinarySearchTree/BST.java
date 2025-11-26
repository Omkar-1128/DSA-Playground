package BinarySearchTree;

public class BST {
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

    // // Build a binary search tree
    // public static Node BuildTree(int val ,  Node root) {
    //     if (root == null) {
    //         root = new Node(val);
    //         return root;
    //     }

    //     if (root.data > val) {
    //         // Left Subtree
    //         root.left = BuildTree(val , root.left);
    //     } else {
    //         // Right Subtree
    //         root.right = BuildTree(val, root.right);
    //     }

    //     return root;
    // }

    // public static void InOrder(Node root) {
    //     if (root == null) {
    //         return;
    //     }

    //     InOrder(root.left);
    //     System.out.print(root.data + " ");
    //     InOrder(root.right);
    // }


    // HomeWork
    public static Node Insert (int val , Node root) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = Insert(val, root.left);
        } else {
            root.right = Insert(val, root.right);
        }

        return root;
    }

    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }

        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }


    public static void main(String[] args) {
        // int value[] = {5 , 1 , 3 , 4 , 2 , 7};
        // Node root = null;
        // for (int i = 0 ; i < value.length ; i++) {
        //     root = BuildTree(value[i] , root);
        // }
        
        // InOrder(root);

        // Printing Numbers from 1->10
        int value[] = {1 , 2 , 3, 4 , 5 , 6 , 7 , 8 , 9 , 10};
        Node root = null;
        for (int i = 0 ; i < value.length ; i++) {
            root = Insert(value[i], root);
        }

        Inorder(root);
    }
}
