import java.util.*;

class Solution {
    private Map<Integer, List<TreeNode>> memo = new HashMap<>();
    
    public List<TreeNode> allPossibleFBT(int n) {
        // Base case: If n is even, there are no full binary trees
        if (n % 2 == 0) return new ArrayList<>();
        
        // If result is already computed, return it
        if (memo.containsKey(n)) return memo.get(n);
        
        List<TreeNode> result = new ArrayList<>();
        
        // Base case: If n == 1, the only tree is a single node
        if (n == 1) {
            result.add(new TreeNode(0));
            memo.put(n, result);
            return result;
        }
        
        // Recursive case: Iterate over all possible left and right subtree sizes
        for (int leftNodes = 1; leftNodes < n; leftNodes += 2) {
            int rightNodes = n - 1 - leftNodes;
            List<TreeNode> leftTrees = allPossibleFBT(leftNodes);
            List<TreeNode> rightTrees = allPossibleFBT(rightNodes);
            
            // Combine left and right subtrees
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        
        // Store result in memo and return
        memo.put(n, result);
        return result;
    }
}
