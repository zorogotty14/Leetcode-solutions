class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base case: If both nodes are null, they are equivalent
        if (root1 == null && root2 == null) return true;
        
        // If one of the nodes is null or their values don't match, they are not equivalent
        if (root1 == null || root2 == null || root1.val != root2.val) return false;
        
        // Check if the children are flip equivalent without flip or with flip
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        // Return true if either noFlip or flip is true
        return noFlip || flip;
    }
}
