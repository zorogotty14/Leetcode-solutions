import java.util.*;

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;
        
        // Queue for BFS traversal, storing node and its parent.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Initialize the root node value to 0 (as it has no cousins).
        root.val = 0;

        // Perform BFS level by level.
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int levelSum = 0;
            List<TreeNode> levelNodes = new ArrayList<>();

            // Traverse all nodes at the current level.
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelNodes.add(node);

                // Sum the values of nodes at the current level.
                if (node.left != null) {
                    levelSum += node.left.val;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    levelSum += node.right.val;
                    queue.add(node.right);
                }
            }

            // Replace the value of each node based on its cousins' sum.
            for (TreeNode node : levelNodes) {
                int siblingSum = 0;
                if (node.left != null) siblingSum += node.left.val;
                if (node.right != null) siblingSum += node.right.val;

                // Update the children's values with the cousins' sum.
                if (node.left != null) node.left.val = levelSum - siblingSum;
                if (node.right != null) node.right.val = levelSum - siblingSum;
            }
        }

        return root;
    }
}
