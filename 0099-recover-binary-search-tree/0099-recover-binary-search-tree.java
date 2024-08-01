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
    public void recoverTree(TreeNode root) {
        TreeNode first = null, second = null;
        TreeNode prev = null, pred = null;
        
        while (root != null) {
            if (root.left != null) {
                // Find the predecessor
                pred = root.left;
                while (pred.right != null && pred.right != root) {
                    pred = pred.right;
                }
                
                if (pred.right == null) {
                    // Linking to root to revisit after left subtree
                    pred.right = root;
                    root = root.left;
                } else {
                    // Visiting node
                    if (prev != null && prev.val > root.val) {
                        if (first == null) first = prev;
                        second = root;
                    }
                    prev = root;
                    
                    // Restore the tree structure
                    pred.right = null;
                    root = root.right;
                }
            } else {
                // Visiting node
                if (prev != null && prev.val > root.val) {
                    if (first == null) first = prev;
                    second = root;
                }
                prev = root;
                root = root.right;
            }
        }
        
        // Swap the values of the two nodes
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
}