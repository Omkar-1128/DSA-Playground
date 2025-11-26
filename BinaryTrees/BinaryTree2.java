package BinaryTrees;

public class BinaryTree2 {
    static class Node {
        int data;
        Node left;
        Node right;
        
        public Node (int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

        // Height of Binary Tree
        public static int Height (Node root) {   // O(n)
            if (root == null) {
                return 0;
            }

            int LH = Height(root.left);
            int RH = Height(root.right);

            return Math.max(LH, RH) + 1;
        }

        // Count Number of Nodes
        public static int countNodes(Node root) {    // O(n)
            if (root == null) {
                return 0;
            }

            int Lcount = countNodes(root.left);
            int Rcount = countNodes(root.right);

            return Lcount + Rcount + 1;
        }

        // Sum of Nodes
        public static int sum(Node root) {    // O(n)
            if (root == null) {
                return 0;
            }

            int LSum = sum(root.left);
            int Rsum = sum(root.right);

            return LSum + Rsum + root.data;
        }
    }

    public static void main(String[] args) {
        //         1
        //       /  \
        //      2    3
        //    /  \  /  \
        //   4   5  6   7

        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right = new Node(3);
        newNode.right.left = new Node(6);
        newNode.right.right = new Node(7);

        System.out.println("Height -> " + Node.Height(newNode));
        System.out.println("Total Number of Nodes -> " + Node.countNodes(newNode));
        System.out.println("Sum of nodes -> " + Node.sum(newNode));
    }
}
