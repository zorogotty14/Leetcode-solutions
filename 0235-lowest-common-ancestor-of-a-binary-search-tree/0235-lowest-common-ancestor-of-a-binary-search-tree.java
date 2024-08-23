/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Start from the root node of the BST
        TreeNode currentNode = root;
        
        while (currentNode != null) {
            // If both p and q are greater than currentNode, then LCA lies in the right subtree
            if (p.val > currentNode.val && q.val > currentNode.val) {
                currentNode = currentNode.right;
            }
            // If both p and q are smaller than currentNode, then LCA lies in the left subtree
            else if (p.val < currentNode.val && q.val < currentNode.val) {
                currentNode = currentNode.left;
            }
            // Otherwise, currentNode is the LCA
            else {
                return currentNode;
            }
        }
        
        return null; // This will never be reached since p and q are guaranteed to exist in the BST.
    }
}
