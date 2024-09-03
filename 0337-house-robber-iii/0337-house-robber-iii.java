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
    public int rob(TreeNode root) {
        int[] result = robSubtree(root);
        return Math.max(result[0], result[1]);
    }

    private int[] robSubtree(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // Recursively solve the left and right subtrees
        int[] left = robSubtree(node.left);
        int[] right = robSubtree(node.right);

        // result[0] is if we do not rob this node
        // result[1] is if we do rob this node
        int[] result = new int[2];

        // If we rob this node, we can't rob its children
        result[1] = node.val + left[0] + right[0];

        // If we do not rob this node, we take the max of robbing or not robbing its children
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
}
