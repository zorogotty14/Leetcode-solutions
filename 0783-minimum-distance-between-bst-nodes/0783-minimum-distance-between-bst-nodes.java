class Solution {
    private Integer prev = null;
    private int minDiff = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    private void inOrderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // In-order traversal: Left -> Node -> Right
        inOrderTraversal(node.left);

        // If prev is not null, update the minimum difference
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev);
        }

        // Update prev to the current node's value
        prev = node.val;

        inOrderTraversal(node.right);
    }
}
