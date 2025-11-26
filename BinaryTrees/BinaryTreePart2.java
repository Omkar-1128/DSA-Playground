package BinaryTrees;

public class BinaryTreePart2 {
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

    static class Info {
        int diameter;
        int height;

        public Info(int d , int h) {
            diameter = d;
            height = h;
        }
    }

    public static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int lh = height(root.left);
        int rh = height(root.right);

        return Math.max(lh , rh) + 1;
    }

    // Diameter of a binary tree
    // Approch 1
    // public static int diameter(Node root) {   // O(n2)
    //     if (root == null) {
    //         return 0;
    //     }

    //     int ldiam = diameter(root.left);
    //     int rdiam = diameter(root.right);
    //     int lh = height(root.left);
    //     int rh = height(root.right);
    //     int selfDiam = lh + rh + 1;

    //     return Math.max(Math.max(ldiam , rdiam) , selfDiam);
    // }

    // Approch 2
    public static Info diameter(Node root) {   // O(n)
        if (root == null) {
            return new Info(0 , 0);
        }

        Info LInfo = diameter(root.left);
        Info RInfo = diameter(root.right);

        int maxDiam = Math.max(Math.max(LInfo.diameter , RInfo.diameter) , LInfo.height + RInfo.height + 1);
        int maxHt = Math.max(LInfo.height , RInfo.height) + 1;

        return new Info(maxDiam, maxHt);
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

        System.out.println(BinaryTreePart2.diameter(newNode).diameter);
    }
}
