class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null; // Base case: if the tree is empty
        }

        // Step 1: Search for the node to delete
        if (key < root.val) {
            root.left = deleteNode(root.left, key); // Key is in the left subtree
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key); // Key is in the right subtree
        } else {
            // Node found, perform deletion

            // Case 1: Node has no child (is a leaf node)
            if (root.left == null && root.right == null) {
                return null; // Just remove the node
            }

            // Case 2: Node has one child
            if (root.left == null) {
                return root.right; // Replace with right child
            }
            if (root.right == null) {
                return root.left; // Replace with left child
            }

            // Case 3: Node has two children
            // Find the in-order successor (smallest in the right subtree)
            TreeNode successor = findMin(root.right);
            root.val = successor.val; // Copy the successor's value to this node
            root.right = deleteNode(root.right, successor.val); // Delete the successor
        }
        return root;
    }

    // Helper function to find the minimum value node in a tree (in-order successor)
    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left; // Move left until the leftmost (smallest) node
        }
        return node;
    }
}
