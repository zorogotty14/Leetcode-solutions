class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;
        return dfs(root, root.val);
    }
    
    private int dfs(TreeNode node, int minVal) {
        // Base case: if the node is null, return -1
        if (node == null) return -1;
        
        // If the node's value is greater than the minimum, it could be the second minimum
        if (node.val > minVal) return node.val;
        
        // Recurse on both left and right subtrees
        int left = dfs(node.left, minVal);
        int right = dfs(node.right, minVal);
        
        // If both left and right returned values, return the smaller one
        if (left != -1 && right != -1) return Math.min(left, right);
        
        // If only one of them is valid, return the valid one
        return left != -1 ? left : right;
    }
}
