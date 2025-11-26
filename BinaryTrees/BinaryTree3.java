package BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree3 {
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

    // Kth Level of Binary Tree
    // Iterative Approch
    public static void KthLevel2(Node root , int k) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int level = 1;

        while (!q.isEmpty()) {
            Node curr = q.remove();

            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
                level++;
            } else {
                if (level == k) {
                    System.out.print(curr.data + " ");
                }

                if (curr.left != null) {
                    q.add(curr.left);
                }

                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }
    }

    // Recursive Approch 
    public static void KthLevel(Node root , int level , int k) {
        if (root == null) {
            return;
        }

        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KthLevel(root.left, level + 1 ,k);
        KthLevel(root.right, level + 1 ,k);
    }

    

    // 236. Lowest Common Ancestor of a Binary Tree
    // Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
    // According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

    // Approch 1
    public static boolean getPath(Node root , int n , ArrayList<Node> list) {
        if (root == null) {
            return false;
        }

        list.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, list);
        boolean foundRight = getPath(root.right, n, list);

        if (foundLeft || foundRight) {
            return true;
        }

        list.remove(list.size() - 1);
        return false;
    }

    public static Node CommonAncestor(Node root , int n1 , int n2) {  // O(n)
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1);
        getPath(root, n2, path2);

        // last Common ancestor
        int i = 0;
        for (; i < path1.size() && i < path2.size() ; i++) {
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node -> i - 1
        return path1.get(i - 1);
    }

    // Approch 2
    public static Node CommonAncestor2(Node root , int n1 , int n2) {

        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        
        Node LeftCA = CommonAncestor2(root.left, n1, n2);
        Node RightCA = CommonAncestor2(root.right, n1, n2);

        // left -> valid resp. and right -> null 
        if (RightCA == null) {
            return LeftCA;
        }

        // right -> valid response && left -> null
        if (LeftCA == null) {
            return RightCA;
        }

        return root;
    }

    // Minimum Distance between two nodes
    // find common ancestor
    // find add the both path lenghts from common ancestors

    public static int LCADist(Node node , int n) {
        if (node == null) {
            return -1;
        }

        if (node.data == n) {
            return 0;
        }

        int leftPath = LCADist(node.right, n);
        int rightPath = LCADist(node.left, n);

        if (leftPath == -1 && rightPath == -1) {
            return -1;
        } else {
            if (leftPath != -1) {
                return leftPath + 1;
            } else {
                return rightPath + 1;
            }
        }
    }

    public static int minDist(Node root , int n1 , int n2) {
        Node LCA = CommonAncestor2(root, n1, n2);

        int dist1 = LCADist(LCA, n1);
        int dist2 = LCADist(LCA, n2);

        return dist1 + dist2;
    }

    // Kth Ancestor of node
    public static int KthAncestor(Node root , int k , int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftVal = KthAncestor(root.left, k , n);
        int rightVal = KthAncestor(root.right, k , n);

        if (leftVal == -1 && rightVal == -1) {
            return -1;
        }

        int max = Math.max(leftVal, rightVal);

        if (max+ 1 == k) {
            System.out.println(root.data);
        }

        return max + 1;
    }

    // Transform Tree to sum tree
    // public static int calSum(Node root) {  // makes new tree
    //     // Preorder travel
    //     if (root == null) {
    //         return 0;
    //     }
    //     int leftSum = calSum(root.left);
    //     int rightSum = calSum(root.right);

    //     return root.data + leftSum + rightSum;
    // }

    // public static Node SumTree(Node root) {
    //     if (root == null) {
    //         return null;
    //     }

    //     int val = calSum(root);
    //     Node newNode = new Node(val - root.data);

    //     newNode.left = SumTree(root.left);
    //     newNode.right = SumTree(root.right);

    //     return newNode;
    // }

    // Approch 2
    // More optimized not made mew tree
    public static int Transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftSum = Transform(root.left);
        int rightSum = Transform(root.right);

        int data = root.data;
        int newLeft = root.left == null? 0 : root.left.data;
        int newRight = root.right == null? 0 : root.right.data;
        root.data = newLeft +  leftSum + newRight +  rightSum;

        return data;
    }


    // Level Order Traversal 
    public static void levelOrder(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0 ; i < size ; i++) {
                Node curr = q.remove();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        //        1
        //      /   \
        //     2     3
        //    / \     \
        //   4   5     6

        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.right = new Node(6);

        // KthLevel(newNode, 1 , 3);

        // int n1 = 4;
        // int n2 = 6;
        // Node LCA = CommonAncestor2(newNode, n1, n2);
        // System.out.println("Lowest Common ancestor for " + n1 + " and " + n2 + " is " + LCA.data);

        // System.out.println("Miminum Distance between Two Node: " + minDist(newNode, n1, n2));

        // Kth Ancestor of Node
        // int k = 1;
        // int n = 4; 
        // KthAncestor(newNode, k, n);

        // System.out.println(SumTree(newNode).data);
        // levelOrder(SumTree(newNode));

        System.out.println(Transform(newNode));
        levelOrder(newNode);
    }
}
