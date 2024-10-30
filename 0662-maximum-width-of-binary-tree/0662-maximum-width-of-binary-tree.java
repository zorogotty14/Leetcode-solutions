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
import java.util.*;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        // Queue to perform BFS, storing nodes along with their position indices
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0)); // Start with root at index 0

        int maxWidth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int minIndex = queue.peek().getValue(); // The index of the first node in this level
            int first = 0, last = 0;

            // Iterate over all nodes at the current level
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode node = current.getKey();
                int index = current.getValue() - minIndex; // Normalize index to prevent overflow

                // Update first and last indices
                if (i == 0) first = index;
                if (i == size - 1) last = index;

                // Add children to the queue with their respective indices
                if (node.left != null) {
                    queue.offer(new Pair<>(node.left, 2 * index));
                }
                if (node.right != null) {
                    queue.offer(new Pair<>(node.right, 2 * index + 1));
                }
            }

            // Update the maximum width
            maxWidth = Math.max(maxWidth, last - first + 1);
        }

        return maxWidth;
    }

    // Helper class to store pairs of TreeNode and index
    class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() { return key; }
        public V getValue() { return value; }
    }
}
