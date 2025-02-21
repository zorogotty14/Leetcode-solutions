import java.util.*;

class FindElements {
    private Set<Integer> values; // HashSet to store valid values

    public FindElements(TreeNode root) {
        values = new HashSet<>();
        recoverTree(root, 0); // Start recovery from the root with value 0
    }
    
    private void recoverTree(TreeNode node, int val) {
        if (node == null) return;

        node.val = val; // Assign the correct value
        values.add(val); // Store the recovered value in the HashSet

        // Recurse for left and right children
        recoverTree(node.left, 2 * val + 1);
        recoverTree(node.right, 2 * val + 2);
    }
    
    public boolean find(int target) {
        return values.contains(target); // O(1) lookup
    }
}
