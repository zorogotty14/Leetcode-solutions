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
    public int countPairs(TreeNode root, int distance) {
        
int[] result = new int[1]; // Array to hold the result count
        helper(root, distance, result);
        return result[0];
    }

    // Helper function to perform DFS and collect distances
    private int[] helper(TreeNode node, int distance, int[] result) {
        if (node == null) return new int[11];
        
        if (node.left == null && node.right == null) { // Leaf node
            int[] leaves = new int[11];
            leaves[1] = 1; // Distance from leaf to itself is 1
            return leaves;
        }

        int[] leftLeaves = helper(node.left, distance, result);
        int[] rightLeaves = helper(node.right, distance, result);

        // Count good pairs between left and right subtrees
        for (int i = 1; i <= distance; i++) {
            for (int j = 1; j <= distance; j++) {
                if (i + j <= distance) {
                    result[0] += leftLeaves[i] * rightLeaves[j];
                }
            }
        }

        // Collect distances from the current node to all leaves
        int[] leaves = new int[11];
        for (int i = 1; i < 10; i++) {
            leaves[i + 1] = leftLeaves[i] + rightLeaves[i];
        }

        return leaves;
    }
}