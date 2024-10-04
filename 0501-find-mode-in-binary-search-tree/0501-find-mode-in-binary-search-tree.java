class Solution {
    private Integer prev = null;
    private int maxCount = 0;
    private int currentCount = 0;
    private List<Integer> modes = new ArrayList<>();
    
    public int[] findMode(TreeNode root) {
        // First pass to calculate max frequency
        inorder(root);
        
        // Convert the list to an array and return
        int[] result = new int[modes.size()];
        for (int i = 0; i < modes.size(); i++) {
            result[i] = modes.get(i);
        }
        return result;
    }

    private void handleValue(int value) {
        if (prev == null || value != prev) {
            currentCount = 1;
        } else {
            currentCount++;
        }

        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear(); // Reset modes if we find a new max count
            modes.add(value);
        } else if (currentCount == maxCount) {
            modes.add(value);
        }

        prev = value;
    }

    private void inorder(TreeNode node) {
        if (node == null) return;

        // Traverse left
        inorder(node.left);

        // Process current node
        handleValue(node.val);

        // Traverse right
        inorder(node.right);
    }
}
