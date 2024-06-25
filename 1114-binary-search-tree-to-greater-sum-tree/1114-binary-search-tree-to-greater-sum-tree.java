/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int runningSum = 0;
    public TreeNode bstToGst(TreeNode root) {
        reverseInOrder(root);
        return root;
    }
    private void reverseInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        
        // Traverse right subtree
        reverseInOrder(node.right);
        
        // Update the node's value
        runningSum += node.val;
        node.val = runningSum;
        
        // Traverse left subtree
        reverseInOrder(node.left);
    }

    // Helper function to print the tree in-order for verification
    public void printInOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }
}