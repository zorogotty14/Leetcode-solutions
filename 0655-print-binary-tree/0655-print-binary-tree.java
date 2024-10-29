import java.util.*;


class Solution {
    public List<List<String>> printTree(TreeNode root) {
        // Find the height of the tree
        int height = getHeight(root);
        
        // Calculate number of rows (m) and columns (n)
        int m = height + 1;
        int n = (1 << (height + 1)) - 1; // 2^(height+1) - 1

        // Initialize the matrix with empty strings
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<String> row = new ArrayList<>(Collections.nCopies(n, ""));
            res.add(row);
        }

        // Populate the matrix with the tree nodes
        fillMatrix(root, res, 0, 0, n - 1, height);

        return res;
    }

    // Helper function to fill the matrix recursively
    private void fillMatrix(TreeNode node, List<List<String>> res, int row, int left, int right, int height) {
        if (node == null) return;

        // Calculate the column position for the current node
        int col = (left + right) / 2;
        res.get(row).set(col, Integer.toString(node.val));

        // Recursively place the left and right children
        fillMatrix(node.left, res, row + 1, left, col - 1, height);
        fillMatrix(node.right, res, row + 1, col + 1, right, height);
    }

    // Helper function to calculate the height of the tree
    private int getHeight(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}
