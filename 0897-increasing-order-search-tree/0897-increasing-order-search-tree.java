class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode dummyNode = new TreeNode(0); // Dummy node
        TreeNode current = dummyNode; // Pointer to build the new tree

        // In-order traversal to rearrange the tree
        inOrderTraversal(root, current);

        return dummyNode.right; // Return the new root (right of dummy node)
    }

    private TreeNode inOrderTraversal(TreeNode node, TreeNode current) {
        if (node == null) return current;

        // Recursively process the left subtree
        current = inOrderTraversal(node.left, current);

        // Visit the current node
        node.left = null; // Set left child to null
        current.right = node; // Attach current node as the right child
        current = node; // Move the pointer to the current node

        // Recursively process the right subtree
        return inOrderTraversal(node.right, current);
    }
}
