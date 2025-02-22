import java.util.*;

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            // Step 1: Compute depth
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Step 2: Compute node value
            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Step 3: Create the new node
            TreeNode node = new TreeNode(value);

            // Step 4: Find its parent
            while (stack.size() > depth) {
                stack.pop(); // Move up the tree until we reach the correct depth
            }

            // Step 5: Attach the node as left or right child
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;  // Left child first
                } else {
                    parent.right = node; // Then right child
                }
            }

            // Step 6: Push the node onto the stack
            stack.push(node);
        }

        // The root of the tree is the first element inserted into the stack
        while (stack.size() > 1) {
            stack.pop();
        }
        return stack.peek();
    }
}
