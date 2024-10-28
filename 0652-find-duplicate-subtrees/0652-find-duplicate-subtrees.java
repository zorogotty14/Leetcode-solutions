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
    // HashMap to store the serialized form of subtrees and their frequencies
    Map<String, Integer> subtreeMap = new HashMap<>();
    // List to store the roots of duplicate subtrees
    List<TreeNode> duplicates = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        serializeTree(root);
        return duplicates;
    }

    // Helper method to serialize each subtree
    private String serializeTree(TreeNode node) {
        if (node == null) {
            return "#"; // Use # to represent null nodes
        }

        // Serialize the subtree rooted at the current node
        String serialized = node.val + "," + serializeTree(node.left) + "," + serializeTree(node.right);

        // Update the frequency of the serialized subtree in the map
        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);

        // If this is the second occurrence of this subtree, add it to the result list
        if (subtreeMap.get(serialized) == 2) {
            duplicates.add(node);
        }

        return serialized;
    }
}