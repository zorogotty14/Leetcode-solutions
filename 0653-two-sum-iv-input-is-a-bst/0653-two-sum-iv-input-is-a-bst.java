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
    public boolean findTarget(TreeNode root, int k) {
        // HashSet to store visited values
        Set<Integer> seen = new HashSet<>();
        // Perform in-order traversal to search for the target sum
        return inOrder(root, k, seen);
    }

    // Helper method to perform in-order traversal
    private boolean inOrder(TreeNode node, int k, Set<Integer> seen) {
        if (node == null) {
            return false;
        }

        // Check if the complement of the current node's value exists in the set
        if (seen.contains(k - node.val)) {
            return true;
        }

        // Add the current node's value to the set
        seen.add(node.val);

        // Recursively search in the left and right subtrees
        return inOrder(node.left, k, seen) || inOrder(node.right, k, seen);
    }
}
