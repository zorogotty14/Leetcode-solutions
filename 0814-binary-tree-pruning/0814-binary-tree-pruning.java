class Solution {
    public TreeNode pruneTree(TreeNode root) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Recursively prune the left and right subtrees
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);

        // Check if the current node should be pruned
        if (root.val == 0 && root.left == null && root.right == null) {
            return null; // Prune the node
        }

        return root; // Retain the node
    }
}
