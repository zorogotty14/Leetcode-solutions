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
    public String tree2str(TreeNode root) {
        if (root == null) return "";

        // Convert the current node's value to a string
        StringBuilder result = new StringBuilder();
        result.append(root.val);

        // If there is a left child, process it
        if (root.left != null) {
            result.append("(").append(tree2str(root.left)).append(")");
        }

        // If there is no left child but there is a right child,
        // we need to include empty parentheses for the left child.
        if (root.left == null && root.right != null) {
            result.append("()");
        }

        // If there is a right child, process it
        if (root.right != null) {
            result.append("(").append(tree2str(root.right)).append(")");
        }

        return result.toString();
    }
}