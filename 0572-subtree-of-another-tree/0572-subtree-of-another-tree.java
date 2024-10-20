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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;  // If root is null, subRoot cannot be a subtree
        }
        
        // Check if the current subtree matches or search in the left/right subtrees
        if (isSameTree(root, subRoot)) {
            return true;
        }
        
        // Recursively check left and right subtrees of the root
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    // Helper function to check if two trees are identical
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;  // Both nodes are null, so they are identical
        }
        if (p == null || q == null) {
            return false;  // One node is null, the other is not
        }
        if (p.val != q.val) {
            return false;  // Values of the nodes don't match
        }
        
        // Recursively compare left and right children
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
