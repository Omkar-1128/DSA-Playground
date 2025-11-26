package BinarySearchTree;

import java.util.Stack;

import javax.swing.tree.TreeNode;

public class PQ {

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

    // Find the closest element in Binary Search Tree
    // We have a binary search tree and a target node K. The task is to find the
    // node with minimum
    // absolute difference with given target value K.
    //          8
    //         / \
    //        5  11
    //       / \   \
    //      3   6  20

    public static Node closest(int k, Node root) {
        Node closest = root;

        while (root != null) {
            if (Math.abs(closest.data - k) > Math.abs(root.data - k)) {
                closest =  root;
            }

            if (root.data < k) {
                root = root.right;
            } else if (root.data > k) {
                root = root.left;
            } else {
                break;
            }
        }

        return closest;
    }

    // Find k-th smallest element in BST
    // We have the root of a binary search tree and K as input, find Kth smallest element in BST.
    //        8
    //       / \
    //      5  11
    //     / \   \
    //    3   6   20
    // Sample Input 1 : k=3
    // Sample Output 1 : 8
    // Sample Input 2 : k=5
    // Sample Output 2 : 5

    // class Solution {
    // static int count;

    // public static TreeNode travel(TreeNode root , int k) {
    //     if (root == null) {
    //         return null;
    //     }

    //     TreeNode left = travel(root.left , k);
    //     if (left != null) {
    //         return left;
    //     }
    //     count++;
    //     if (count == k) {
    //         return root;
    //     }
    //     return travel(root.right , k);
    // }

    // public int kthSmallest(TreeNode root, int k) {
    //     count = 0;
    //     return travel(root , k).val;
    // }

    // Two Sum BSTs
    // Given a BST, transform it into a greater sum tree where each node contains sum of all nodes
    // greater than that node.
    
    public static void TwoSum(Node root1 , Node root2 , int x) {
        if (root1 == null || root2 == null) {
            return;
        }
        Node top1 , top2;
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        while (true) {
            while (root1 != null) {
                s1.push(root1);
                root1 = root1.left;
            }
            while (root2 != null) {
                s2.push(root2);
                root2 = root2.right;
            }

            if (s1.isEmpty() || s2.isEmpty()) break;
            
            top1 = s1.peek();
            top2 = s2.peek();

            if (top1.data + top2.data == x) {
                System.out.println(top1.data + "," + top2.data);
                s1.pop();
                s2.pop();
                root1 = top1.right;
                root2 = top2.left;
                continue;
            }

            if (top1.data + top2.data < x) {
                s1.pop();
                root1 = top1.right;
            } else {
                s2.pop();
                root2 = top2.left;
            }
        }
    }

    public static void main(String[] args) {
        // Node root = new Node(8);
        // root.left = new Node(5);
        // root.left.left = new Node(3);
        // root.left.right = new Node(6);
        // root.right = new Node(11);
        // root.right.right = new Node(20);

        // Node closest = closest(19, root);
        // System.out.println(closest.data);



        // Sample Input 1 :
    //      5
    //     / \
    //    3   7       // Tree 1 
    //   / \ / \
    //  2  4 6  8
        Node root1 = new Node(5);
        root1.left = new Node(3);
        root1.left.left = new Node(2);
        root1.left.right = new Node(4);
        root1.right = new Node(7);
        root1.right.left = new Node(6);
        root1.right.right = new Node(8);


    //      10
    //     /  \
    //    6   15     // Tree 2
    //   / \  / \
    //  3  8 11 18
    // x = 16
    // Sample Output 1 : 3
    // The pairs are:
    // (5, 11), (6, 10) and (8, 8)

        Node root2 = new Node(10);
        root2.left = new Node(6);
        root2.left.left = new Node(3);
        root2.left.right = new Node(8);
        root2.right = new Node(15);
        root2.right.left = new Node(11);
        root2.right.right = new Node(18);

        TwoSum(root1, root2 , 16);
    }
}
