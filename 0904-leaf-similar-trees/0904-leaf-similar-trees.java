import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        
        // Collect leaf sequences for both trees
        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);
        
        // Compare the two sequences
        return leaves1.equals(leaves2);
    }
    
    // Helper method to collect leaf values using DFS
    private void collectLeaves(TreeNode node, List<Integer> leaves) {
        if (node == null) {
            return;
        }
        
        // Check if the current node is a leaf
        if (node.left == null && node.right == null) {
            leaves.add(node.val);
        }
        
        // Traverse left and right subtrees
        collectLeaves(node.left, leaves);
        collectLeaves(node.right, leaves);
    }
}
