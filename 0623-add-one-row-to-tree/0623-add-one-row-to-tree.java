/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        // Case: If depth is 1, create a new root
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        // Use BFS to reach nodes at depth - 1
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int currentDepth = 1;

        // Traverse the tree until we reach depth - 1
        while (!queue.isEmpty() && currentDepth < depth - 1) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            currentDepth++;
        }

        // Now we are at depth - 1, add the new row
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            // Insert new nodes with value val
            TreeNode newLeft = new TreeNode(val, node.left, null);
            TreeNode newRight = new TreeNode(val, null, node.right);
            node.left = newLeft;
            node.right = newRight;
        }

        return root;
    }
}
