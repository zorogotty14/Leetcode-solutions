import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }
    
    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            return;
        }
        sb.append(root.val).append(" "); // Pre-order: Add root
        serializeHelper(root.left, sb);   // Recursively add left subtree
        serializeHelper(root.right, sb);  // Recursively add right subtree
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<Integer> nodes = new LinkedList<>();
        for (String s : data.split(" ")) {
            nodes.offer(Integer.parseInt(s)); // Queue to hold node values
        }
        return deserializeHelper(nodes, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode deserializeHelper(Queue<Integer> nodes, int lower, int upper) {
        if (nodes.isEmpty()) return null;
        
        int value = nodes.peek();
        if (value < lower || value > upper) return null; // Ensure the value is within bounds
        
        nodes.poll(); // Remove the value from the queue since it's being used
        
        TreeNode root = new TreeNode(value); // Create a new node with the value
        root.left = deserializeHelper(nodes, lower, value);   // Recursively build left subtree
        root.right = deserializeHelper(nodes, value, upper);  // Recursively build right subtree
        
        return root;
    }
}
