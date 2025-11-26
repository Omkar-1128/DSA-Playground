package BinarySearchTree;

import java.util.ArrayList;

// Time Complexity of Searching -> O(n)
public class BST2 {
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

    public static boolean Search(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return Search(root.left, key);
        } else {
            return Search(root.right, key);
        }
    }

    public static Node Insert(Node root , int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data < val) {
            root.right = Insert(root.right, val);
        } else {
            root.left = Insert(root.left, val);
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

    // find leftMost node
    public static Node findInOrderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    // Delete a node in BST
    public static Node Delete(int key, Node root) {
        if (root.data > key) {
            root.left = Delete(key, root.left);
        } else if (root.data < key) {
            root.right = Delete(key, root.right);
        } else {
            //case 1
            // If the node is leaf node 
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            // If the nodes contains single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            // If the node contains two Children

            Node ls = findInOrderSuccessor(root.right);
            root.data = ls.data;
            root.right = Delete(ls.data, root.right);          
        } 
        return root;
    }

    // Print in Range
    public static void PrintInRange(Node root , int k1 , int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            PrintInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            PrintInRange(root.right, k1, k2);
        } else if (root.data > k1) {
            PrintInRange(root.left, k1, k2);
        } else if (root.data < k2) {
            PrintInRange(root.right, k1, k2);
        }
    }

    // Root to Leaft Path
    public static void PrintPath(Node root , ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) {
            for (int i = 0 ; i < path.size() ; i++) {
                System.out.print(path.get(i) + "->");
            }  
            System.out.println("N");
        } 
        PrintPath(root.left , path);
        PrintPath(root.right , path);
        path.remove(path.size() - 1);
    }
    public static void main(String[] args) { 
        int data[] = {4, 3, 2  , 8 , 0 , 6};
        Node root = null;
        
        for (int i = 0 ; i < data.length ; i++) {
            root = Insert(root, data[i]);
        }

        Inorder(root);
        System.out.println();
        // if (Search(root, 6)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }

        // Delete(8, root);

        // Inorder(root);

        // PrintInRange(root, 3, 6);

        PrintPath(root , new ArrayList<>());
    }
}
