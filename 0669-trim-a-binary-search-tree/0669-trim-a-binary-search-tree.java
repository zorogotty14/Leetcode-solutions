class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }
        
        // If the current node's value is less than low, trim the left subtree
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        
        // If the current node's value is greater than high, trim the right subtree
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        
        // If the current node's value is within the range, recursively trim both subtrees
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        
        return root; // return the root of the trimmed tree
    }
}
