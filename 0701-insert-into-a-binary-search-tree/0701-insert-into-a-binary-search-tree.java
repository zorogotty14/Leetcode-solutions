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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // If root is null, create a new node with the given value
            return new TreeNode(val);
        }

        if (val < root.val) {
            // If the value is less than the current node's value, insert into the left subtree
            root.left = insertIntoBST(root.left, val);
        } else {
            // If the value is greater than the current node's value, insert into the right subtree
            root.right = insertIntoBST(root.right, val);
        }

        return root; // Return the root node after insertion
    }
}
