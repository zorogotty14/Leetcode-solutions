class Solution {
    private int maxLength = 0;
    
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return maxLength;
    }
    
    private int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // Recursively find the longest path in the left and right subtrees
        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);
        
        // Variables to store path lengths if they match the current node's value
        int leftMax = 0, rightMax = 0;
        
        // If left child has the same value, extend the left path
        if (node.left != null && node.left.val == node.val) {
            leftMax = leftPath + 1;
        }
        
        // If right child has the same value, extend the right path
        if (node.right != null && node.right.val == node.val) {
            rightMax = rightPath + 1;
        }
        
        // Update the maximum path that goes through the current node
        maxLength = Math.max(maxLength, leftMax + rightMax);
        
        // Return the longest one-side path for the current node
        return Math.max(leftMax, rightMax);
    }
}
