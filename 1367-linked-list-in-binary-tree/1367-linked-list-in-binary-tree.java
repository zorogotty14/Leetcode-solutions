class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) return false;
        // Check if we can find the path starting from this node
        return dfs(root, head) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    // Helper function to check if we can match the list starting from this tree node
    private boolean dfs(TreeNode root, ListNode head) {
        // If we reach the end of the linked list, it means we found a match
        if (head == null) return true;
        // If we reach a null node in the tree, return false
        if (root == null) return false;
        
        // Check if current values match and proceed downwards
        if (root.val == head.val) {
            return dfs(root.left, head.next) || dfs(root.right, head.next);
        } else {
            return false;
        }
    }
}
