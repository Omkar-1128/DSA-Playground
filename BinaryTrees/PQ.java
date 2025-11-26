// Check if a Binary Tree is univalued or not
// We have a binary tree, the task is to check if the binary tree is univalued or not. If found to be
// true, then print “YES”. Otherwise, print “NO”.

// class Solution {
//     public boolean isUnivalTree(TreeNode root) {
//         if (root == null) {
//             return true;
//         }
        
//         if (root.left != null && root.val != root.left.val) {
//             return false;
//         } 
//         if (root.right != null && root.val != root.right.val) {
//             return false;
//         }
        
//         return isUnivalTree(root.left) && isUnivalTree(root.right);
//     }
// }


// Delete leaf nodes with values as x
// We have a binary tree and a target integer x, delete all the leaf nodes having value as x. Also,
// delete the newly formed leaves with the target value as x.

// class Solution {
//     public TreeNode removeLeafNodes(TreeNode root, int target) {
//         if (root == null) {
//             return null;
//         }

//         root.left = removeLeafNodes(root.left , target);
//         root.right = removeLeafNodes(root.right , target);

//         if ((root.left == null && root.right == null) && root.val == target) {
//             return null;
//         }

//         return root;
//     }
// }


// Maximum Path Sum in a Binary Tree
// We have a binary tree, find the maximum path sum. The path may start and end at any node in
// the tree.


// class Solution {
//     public static int maxSum;
//     public int maxPathSum(TreeNode root) {
//         maxSum = Integer.MIN_VALUE;
//         calSum(root);
//         return maxSum;
//     }

//     public static int calSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int leftSum = Math.max(0 , calSum(root.left));
//         int rightSum = Math.max(0 , calSum(root.right));

//         maxSum = Math.max(root.val + leftSum + rightSum , maxSum);
//         return root.val + Math.max(leftSum, rightSum);
//     }
// }


// Invert Binary Tree
// Mirror of a Tree: Mirror of a Binary Tree T is another Binary Tree M(T) with left and right
// children of all non-leaf nodes interchanged.

// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) {
//             return null;
//         }

//         TreeNode temp = invertTree(root.right);
//         root.right = invertTree(root.left);
//         root.left = temp;

//         return root;
//     }
// }
