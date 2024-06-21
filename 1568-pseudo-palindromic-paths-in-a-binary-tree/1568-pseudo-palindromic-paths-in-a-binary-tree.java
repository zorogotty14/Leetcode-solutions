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
    public int pseudoPalindromicPaths (TreeNode root) {
        return dfs(root, 0);
    }
    private int dfs(TreeNode node, int path) {
        if (node == null) return 0;

        // Compute the path so far
        path ^= (1 << node.val);

        // Check if it's a leaf node
        if (node.left == null && node.right == null) {
            // Check if path represents a pseudo-palindromic path
            // path & (path - 1) == 0 checks if there's at most one bit set in the path
            if ((path & (path - 1)) == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        // Continue DFS traversal
        return dfs(node.left, path) + dfs(node.right, path);
    }
}