package BinaryTrees;

import java.util.*;

public class BuildBinaryTree {
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

    static class BinaryTree {
        static int idx = -1;
        
        public static Node buildTree(int nodes[]) {  
            idx++;

            if (nodes[idx] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[idx]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }

        // Preorder Sequence :- RootNode, LeftNode , RightNode 
        public static void Preorder(Node root) {    // TC - O(n)
            if (root == null) {
                // System.out.print(-1 + " ");
                return;
            }

            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }

        // Inorder Sequence :- LeftNode , RootNode , RightNode
        public static void Inorder(Node root) {  // O(n)
            if (root == null) {
                return;
            }

            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }
        
        // Postoder Sequence :- LeftNode , RightNode , RootNode
        public static void Postoder(Node root) {   // O(n)
            if (root == null) {
                return;
            }

            Postoder(root.left);
            Postoder(root.right);
            System.out.print(root.data + " ");
        }

        // Level Order Traversal   // O/P :- 1 2 3 4 5 6 
        // public static void LevelOrder(Node root) {  // O(n)
        //     if (root == null) {
        //         return;
        //     }
        //     Queue<Node> q = new LinkedList<>();
        //     q.add(root);

        //     while (!q.isEmpty()) {
        //         Node currNode = q.remove();
        //         System.out.print(currNode.data + " ");   
        //         if (currNode.left != null) {
        //             q.add(currNode.left);
        //         }
        //         if (currNode.right != null) {
        //             q.add(currNode.right);
        //         }
        //         if (q.isEmpty()) {
        //             break;
        //         }
        //     }
        // }

        // Level Order Traversal 
        // O/P :- 1
        //        2 3
        //        2 4 5 6
        // public static void LevelOrder(Node root) {  // O(n)
        //     if (root == null) {
        //         return;
        //     }

        //     Queue<Node> q = new LinkedList<>();
        //     q.add(root);
        //     q.add(null);

        //     while(!q.isEmpty()) {
        //         Node currNode = q.remove();
        //         if(currNode == null) {
        //             System.out.println();
        //             if (q.isEmpty()) {
        //                 break;
        //             } else {
        //                 q.add(null);
        //             }
        //         } else {
        //             System.out.print(currNode.data + " ");
        //             if (currNode.left != null) {
        //                 q.add(currNode.left);
        //             } 
        //             if (currNode.right != null) {
        //                 q.add(currNode.right);
        //             }
        //         }
        //     }
        // }
        public static void LevelOrder(Node root) {  // O(n)
            Queue<Node> q = new LinkedList<>();

            q.add(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0 ; i < size ; i++) {
                    Node currNode = q.remove();
                    System.out.print(currNode.data + " ");

                    if (currNode.left != null) {
                        q.add(currNode.left);
                    }
                    if (currNode.right != null) {
                        q.add(currNode.right);
                    }
                }

                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        int nodes[] = {1 , 2 , 4 , -1 , -1 , 5 , -1 , -1 , 3 , -1 , 6 , -1 , -1};

        Node root = BinaryTree.buildTree(nodes);

        // System.out.print("PreOrder Traversal -> ");
        // BinaryTree.Preorder(root);

        // System.out.println();

        // System.out.print("InOrder Traversal -> ");
        // BinaryTree.Inorder(root);

        // System.out.println();

        // System.out.print("PostOrder Traversal -> ");
        // BinaryTree.Postoder(root);

        // System.out.println();

        System.out.print("Level Order Traversal -> ");
        System.out.println();
        BinaryTree.LevelOrder(root);

    }
}
