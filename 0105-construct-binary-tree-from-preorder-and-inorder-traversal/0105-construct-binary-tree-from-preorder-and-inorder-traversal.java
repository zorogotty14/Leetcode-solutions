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
    private int preorderIndex = 0;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndexMap = new HashMap<>();
        // Build a hashmap to store the value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeRecursive(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = buildTreeRecursive(preorder, left, inorderIndexMap.get(rootValue) - 1);
        root.right = buildTreeRecursive(preorder, inorderIndexMap.get(rootValue) + 1, right);

        return root;
    }
}