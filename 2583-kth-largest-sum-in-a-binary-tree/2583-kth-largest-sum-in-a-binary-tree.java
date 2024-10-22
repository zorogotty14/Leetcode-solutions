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
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;

        // Use a queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        List<Long> levelSums = new ArrayList<>();

        // Perform BFS and calculate level sums
        while (!queue.isEmpty()) {
            int size = queue.size();
            long levelSum = 0; // Track the sum of the current level

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                levelSum += current.val;

                // Add children to the queue for the next level
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            // Store the sum of this level
            levelSums.add(levelSum);
        }

        // If we have fewer than k levels, return -1
        if (levelSums.size() < k) return -1;

        // Use a max heap to find the kth largest sum
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        // Maintain a heap of size k with the largest sums
        for (long sum : levelSums) {
            minHeap.add(sum);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }

        // The root of the heap will be the kth largest element
        return minHeap.peek();
    }
}