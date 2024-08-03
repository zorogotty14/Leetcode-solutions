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
    public boolean isBalanced(TreeNode root) {
        return checkBalance(root).isBalanced;
    }
    
    private Result checkBalance(TreeNode node) {
        // Base case: An empty tree is balanced and has height -1
        if (node == null) {
            return new Result(true, -1);
        }
        
        // Check left subtree
        Result leftResult = checkBalance(node.left);
        if (!leftResult.isBalanced) {
            return new Result(false, 0); // No need to check further if left subtree is not balanced
        }
        
        // Check right subtree
        Result rightResult = checkBalance(node.right);
        if (!rightResult.isBalanced) {
            return new Result(false, 0); // No need to check further if right subtree is not balanced
        }
        
        // Current node's height
        int height = Math.max(leftResult.height, rightResult.height) + 1;
        
        // Check if current node is balanced
        boolean isBalanced = Math.abs(leftResult.height - rightResult.height) <= 1;
        
        return new Result(isBalanced, height);
    }
    
    // Helper class to store the result
    private static class Result {
        boolean isBalanced;
        int height;
        
        Result(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
     
}