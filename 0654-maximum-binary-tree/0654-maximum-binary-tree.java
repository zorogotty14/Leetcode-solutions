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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    // Helper function to recursively build the tree
    private TreeNode buildTree(int[] nums, int start, int end) {
        // Base case: If the subarray is empty, return null
        if (start > end) {
            return null;
        }

        // Find the index of the maximum element in the current subarray
        int maxIndex = findMaxIndex(nums, start, end);

        // Create the root node with the maximum value
        TreeNode root = new TreeNode(nums[maxIndex]);

        // Recursively build the left and right subtrees
        root.left = buildTree(nums, start, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, end);

        return root;
    }

    // Helper function to find the index of the maximum element in the subarray
    private int findMaxIndex(int[] nums, int start, int end) {
        int maxIndex = start;
        for (int i = start + 1; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
