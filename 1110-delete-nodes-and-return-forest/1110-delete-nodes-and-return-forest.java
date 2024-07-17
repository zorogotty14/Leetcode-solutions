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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = new HashSet<>();
        for (int val : to_delete) {
            toDeleteSet.add(val);
        }
        
        List<TreeNode> forest = new ArrayList<>();
        helper(root, true, toDeleteSet, forest);
        return forest;
    }
    
    private TreeNode helper(TreeNode node, boolean isRoot, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (node == null) {
            return null;
        }
        
        boolean toDelete = toDeleteSet.contains(node.val);
        if (isRoot && !toDelete) {
            forest.add(node);
        }
        
        node.left = helper(node.left, toDelete, toDeleteSet, forest);
        node.right = helper(node.right, toDelete, toDeleteSet, forest);
        
        return toDelete ? null : node;
    }
}