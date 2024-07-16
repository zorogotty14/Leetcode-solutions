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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode lca = findLCA(root, startValue, destValue);
        
        // Find path from LCA to startValue
        StringBuilder pathToStart = new StringBuilder();
        findPath(lca, startValue, pathToStart);
        
        // Find path from LCA to destValue
        StringBuilder pathToDest = new StringBuilder();
        findPath(lca, destValue, pathToDest);
        
        // Convert pathToStart to 'U's
        for (int i = 0; i < pathToStart.length(); i++) {
            pathToStart.setCharAt(i, 'U');
        }
        
        // Combine paths
        return pathToStart.toString() + pathToDest.toString();
    }
    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root;
        }
        
        TreeNode left = findLCA(root.left, p, q);
        TreeNode right = findLCA(root.right, p, q);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    // Helper function to find the path from a node to the target and store it in a string
    private boolean findPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) {
            return false;
        }
        
        if (root.val == target) {
            return true;
        }
        
        path.append('L');
        if (findPath(root.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        path.append('R');
        if (findPath(root.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
}