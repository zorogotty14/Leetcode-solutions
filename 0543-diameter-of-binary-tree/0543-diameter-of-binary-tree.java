class Solution {
    private int maxDiameter = 0;  // Store the maximum diameter
    
    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);  // Call the helper function to compute the depth and update maxDiameter
        return maxDiameter;
    }
    
    // Helper function to calculate the depth of a tree and update the diameter
    private int depth(TreeNode node) {
        if (node == null) {
            return 0;  // Base case: if the node is null, the depth is 0
        }
        
        // Recursively calculate the depth of the left and right subtrees
        int leftDepth = depth(node.left);
        int rightDepth = depth(node.right);
        
        // Update the maximum diameter (sum of left and right depths for the current node)
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        
        // Return the depth of the current node (1 + the maximum of the two subtrees' depths)
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
