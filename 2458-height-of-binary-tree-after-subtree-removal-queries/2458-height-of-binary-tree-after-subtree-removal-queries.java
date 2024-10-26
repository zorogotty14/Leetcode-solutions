import java.util.*;

class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        int n = getTreeSize(root);  // Get the total number of nodes
        int[] height = new int[n + 1];  // Store heights of each node
        Map<Integer, Integer> bestHeightWithoutChild = new HashMap<>(); // Store best height if child is excluded

        // Compute heights of all nodes using DFS
        computeHeights(root, height);

        // Compute the best heights excluding children using another DFS
        computeBestHeights(root, 0, bestHeightWithoutChild, height);

        // Process the queries and compute answers
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int nodeVal = queries[i];
            answer[i] = bestHeightWithoutChild.getOrDefault(nodeVal, 0);
        }

        return answer;
    }

    // Get the total number of nodes in the tree (for height array size)
    private int getTreeSize(TreeNode root) {
        if (root == null) return 0;
        return 1 + getTreeSize(root.left) + getTreeSize(root.right);
    }

    // Compute the height of each node using DFS
    private int computeHeights(TreeNode node, int[] height) {
        if (node == null) return -1;

        int leftHeight = computeHeights(node.left, height);
        int rightHeight = computeHeights(node.right, height);

        height[node.val] = 1 + Math.max(leftHeight, rightHeight);
        return height[node.val];
    }

    // Compute the best height if excluding a particular child using DFS
    private void computeBestHeights(TreeNode node, int heightFromParent, 
                                    Map<Integer, Integer> bestHeightWithoutChild, int[] height) {
        if (node == null) return;

        // Compute the best height for the current node
        bestHeightWithoutChild.put(node.val, Math.max(heightFromParent, 0));

        // Pass down the height excluding each child
        int leftHeight = (node.left != null) ? height[node.left.val] + 1 : 0;
        int rightHeight = (node.right != null) ? height[node.right.val] + 1 : 0;

        // Pass down the max height if we exclude the left child
        computeBestHeights(node.left, Math.max(heightFromParent, rightHeight), bestHeightWithoutChild, height);

        // Pass down the max height if we exclude the right child
        computeBestHeights(node.right, Math.max(heightFromParent, leftHeight), bestHeightWithoutChild, height);
    }
}
