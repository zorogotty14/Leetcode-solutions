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
 */
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;  // Return root if it's null or matches the val
        }
        
        if (val < root.val) {
            // Search in the left subtree if val is less than root's value
            return searchBST(root.left, val);
        } else {
            // Search in the right subtree if val is greater than root's value
            return searchBST(root.right, val);
        }
    }
}
