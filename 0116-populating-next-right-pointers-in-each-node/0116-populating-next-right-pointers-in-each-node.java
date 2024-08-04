
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        
        Node leftmost = root; // Start with the root node
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                // Connect the left and right children
                head.left.next = head.right;
                
                // Connect the right child to the next node's left child
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                
                // Move to the next node on the current level
                head = head.next;
            }
            
            // Move to the next level
            leftmost = leftmost.left;
        }
        
        return root;
    }
}