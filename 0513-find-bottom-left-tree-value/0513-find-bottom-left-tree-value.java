import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int leftmostValue = root.val;  // Initialize with the root value

        while (!queue.isEmpty()) {
            int size = queue.size();  // Get the number of nodes at the current level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                // The first node in this level is the leftmost one
                if (i == 0) {
                    leftmostValue = current.val;
                }

                // Add the left and right children to the queue (if they exist)
                if (current.left != null) {
                    queue.offer(current.left);
                }
                if (current.right != null) {
                    queue.offer(current.right);
                }
            }
        }

        return leftmostValue;  // After traversing all levels, return the last recorded leftmost value
    }
}
