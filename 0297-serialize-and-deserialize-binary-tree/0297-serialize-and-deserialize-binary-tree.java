import java.util.*;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        
        // Remove the last comma
        sb.setLength(sb.length() - 1);
        
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        int i = 1;
        while (i < values.length) {
            TreeNode node = queue.poll();
            
            if (!values[i].equals("null")) {
                TreeNode leftChild = new TreeNode(Integer.parseInt(values[i]));
                node.left = leftChild;
                queue.add(leftChild);
            }
            i++;
            
            if (i < values.length && !values[i].equals("null")) {
                TreeNode rightChild = new TreeNode(Integer.parseInt(values[i]));
                node.right = rightChild;
                queue.add(rightChild);
            }
            i++;
        }
        
        return root;
    }
}
