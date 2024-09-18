/*
 // Definition for a Node.
 class Node {
     public int val;
     public Node prev;
     public Node next;
     public Node child;
 };
*/

class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        // Start the flattening process
        flattenDFS(head);
        return head; // Return the head of the flattened list
    }
    
    private Node flattenDFS(Node node) {
        Node current = node;
        Node last = node; // To keep track of the last node in the flattened list
    
        while (current != null) {
            Node next = current.next;
            
            if (current.child != null) {
                // Flatten the child list recursively
                Node childHead = current.child;
                Node childTail = flattenDFS(childHead);
                
                // Insert the child list between current and next
                current.next = childHead;
                childHead.prev = current;
                
                // If there is a next node, connect it to the tail of the child list
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                
                current.child = null; // Remove the child pointer
                last = childTail;     // Update last node
                current = next;       // Move current to the next node after the child list
            } else {
                last = current;       // Update last node
                current = current.next; // Move to the next node
            }
        }
        return last; // Return the last node in the flattened list
    }
}
