package BinaryTrees;

public class SubtreeOfAnotherTree {
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

    public static boolean isIdentical(Node node , Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        } else if (node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }

        return isIdentical(node.left, subRoot.left) && isIdentical(node.right, subRoot.right);
    }

    public static boolean isSubtree(Node root , Node subRoot) {
        if (root == null) {
            return false;
        }
       // is identical
        if (root.data == subRoot.data) {
            if (isIdentical(root , subRoot)) {
                return true;
            }
        }

        return isSubtree(root.left , subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        //      tree                    subtree
        //        1
        //      /   \
        //     2     3                    2
        //    / \     \                 /   \
        //   4   5     6               4     5

        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.left = new Node(4);
        newNode.left.right = new Node(5);
        newNode.right.right = new Node(6);

        Node subRoot = new Node(2);
        subRoot.left = new Node(4);
        subRoot.right = new Node(5);
        // subRoot.right.right = new Node(9);

        System.out.println(isSubtree(newNode, subRoot));
    }
}
