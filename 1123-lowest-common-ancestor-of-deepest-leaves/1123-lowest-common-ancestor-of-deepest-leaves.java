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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // Using a pair to return both the depth and the LCA node
        return findLCAAndDepth(root).node;
    }
    
    // Helper class to store both a node and its depth
    private class Pair {
        TreeNode node;
        int depth;
        
        Pair(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }
    
    // Recursive function that returns the LCA and the depth of deepest leaves
    private Pair findLCAAndDepth(TreeNode root) {
        if (root == null) {
            return new Pair(null, 0);
        }
        
        // Recursively find the LCA and depth for left and right subtrees
        Pair left = findLCAAndDepth(root.left);
        Pair right = findLCAAndDepth(root.right);
        
        // If depths are equal, current node is the LCA
        if (left.depth == right.depth) {
            return new Pair(root, left.depth + 1);
        }
        
        // If left subtree has deeper leaves, return left with increased depth
        if (left.depth > right.depth) {
            return new Pair(left.node, left.depth + 1);
        }
        
        // If right subtree has deeper leaves, return right with increased depth
        return new Pair(right.node, right.depth + 1);
    }
}