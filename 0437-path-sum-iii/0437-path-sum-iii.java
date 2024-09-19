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
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        // HashMap to store (prefixSum, frequency) pairs
        Map<Long, Integer> prefixSumMap = new HashMap<>();
        // Initialize with prefix sum 0 having one count
        prefixSumMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumMap);
    }

    private int dfs(TreeNode node, long currSum, int targetSum, Map<Long, Integer> prefixSumMap) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        // Update the current sum
        currSum += node.val;

        // Check if there is a subpath (from any ancestor node to current node) that sums up to targetSum
        count += prefixSumMap.getOrDefault(currSum - targetSum, 0);

        // Update the prefixSumMap with the current sum
        prefixSumMap.put(currSum, prefixSumMap.getOrDefault(currSum, 0) + 1);

        // Recurse on left and right children
        count += dfs(node.left, currSum, targetSum, prefixSumMap);
        count += dfs(node.right, currSum, targetSum, prefixSumMap);

        // Remove the current sum from the map to backtrack
        prefixSumMap.put(currSum, prefixSumMap.get(currSum) - 1);

        return count;
    }
}
