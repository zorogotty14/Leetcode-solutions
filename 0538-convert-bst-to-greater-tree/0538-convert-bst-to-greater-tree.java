class Solution {
    private int sum = 0; // This will store the accumulated sum of greater nodes
    
    public TreeNode convertBST(TreeNode root) {
        // Perform reverse in-order traversal
        if (root == null) {
            return null; // Base case: if the node is null, just return
        }
        
        // Traverse the right subtree first (largest nodes)
        convertBST(root.right);
        
        // Update the current node's value with the running sum
        sum += root.val;
        root.val = sum;
        
        // Traverse the left subtree
        convertBST(root.left);
        
        return root; // Return the modified tree
    }
}
