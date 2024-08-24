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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }
        findPaths(root, "", paths);
        return paths;
    }
    
    private void findPaths(TreeNode node, String path, List<String> paths) {
        if (node.left == null && node.right == null) {
            // Leaf node, add the path to the list
            paths.add(path + node.val);
            return;
        }
        
        // If it's not a leaf, append the current node value to the path and traverse further
        if (node.left != null) {
            findPaths(node.left, path + node.val + "->", paths);
        }
        
        if (node.right != null) {
            findPaths(node.right, path + node.val + "->", paths);
        }
    }
}
