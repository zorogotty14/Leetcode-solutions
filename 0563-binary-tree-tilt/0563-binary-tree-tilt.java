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
    private int totalTilt = 0; // To store the total tilt of all nodes

    public int findTilt(TreeNode root) {
        // Helper function to calculate the sum of subtrees and node tilt
        calculateSumAndTilt(root);
        return totalTilt;
    }

    // This function returns the sum of all nodes in the subtree rooted at `node`
    private int calculateSumAndTilt(TreeNode node) {
        if (node == null) {
            return 0; // Base case: If the node is null, the sum is 0
        }

        // Recursively calculate the sum of the left and right subtrees
        int leftSum = calculateSumAndTilt(node.left);
        int rightSum = calculateSumAndTilt(node.right);

        // Calculate the tilt of the current node
        int tilt = Math.abs(leftSum - rightSum);

        // Add the current node's tilt to the total tilt
        totalTilt += tilt;

        // Return the sum of values for the current subtree (including the current node)
        return node.val + leftSum + rightSum;
    }
}