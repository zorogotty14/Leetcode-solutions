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
    private int postorderIndex;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        // Build a hashmap to store the value -> index relations
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return buildTreeRecursive(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeRecursive(int[] inorder, int[] postorder, int left, int right) {
        // If there are no elements to construct the tree
        if (left > right) {
            return null;
        }

        // Select the postorderIndex element as the root and decrement it
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Build right and left subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.right = buildTreeRecursive(inorder, postorder, inorderIndexMap.get(rootValue) + 1, right);
        root.left = buildTreeRecursive(inorder, postorder, left, inorderIndexMap.get(rootValue) - 1);

        return root;
    }
}