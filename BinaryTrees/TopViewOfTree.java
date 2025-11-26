package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopViewOfTree {
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


    // Level Oder Traversal
    // Horizontal Distance
    // Hash Map

    static class Info {
        Node node;
        int hd;
        
        public Info(Node node , int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static void TopView(Node root) {
        if (root == null) {
            return;
        }
        
        // Horizontal Diatance , CurrNode
        HashMap<Integer , Node> map = new HashMap<>();
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(root , 0));
        map.put(0, root);
        int minhd = 0 , maxhd = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0 ; i < size ; i++) {
                Info currInfo = q.remove();

                minhd = Math.min(minhd, currInfo.hd);
                maxhd = Math.max(maxhd, currInfo.hd);

                if (!map.containsKey(currInfo.hd)) {
                    map.put(currInfo.hd, currInfo.node);
                }

                if (currInfo.node.left != null) {
                    q.add(new Info(currInfo.node.left , currInfo.hd - 1));
                }

                if (currInfo.node.right != null) {
                    q.add(new Info(currInfo.node.right , currInfo.hd + 1));
                }
            }
        }

        System.out.println("Top View Of Binary Tree :- ");
        for (int i = minhd ; i <= maxhd ; i++) {
            System.out.print(map.get(i).data + " ");
        }
    }

    public static void main(String[] args) {
        // Structure
        //           1
        //          / \
        //         2   3
        //          \
        //           4
        //            \
        //             5
        //              \
        //               6    

        Node newNode = new Node(1);
        newNode.left = new Node(2);
        newNode.right = new Node(3);
        newNode.left.right = new Node(4);
        newNode.left.right.right = new Node(5);
        newNode.left.right.right.right = new Node(6);

        TopView(newNode);
    }
}
