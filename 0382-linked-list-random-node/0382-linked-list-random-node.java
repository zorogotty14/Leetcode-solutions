import java.util.Random;

class Solution {
    private ListNode head;
    private Random rand;

    // Constructor: Initialize the object with the head of the linked list.
    public Solution(ListNode head) {
        this.head = head;
        this.rand = new Random();
    }
    
    // getRandom: Choose a random node's value from the linked list.
    public int getRandom() {
        ListNode current = head;
        int result = current.val;  // Start with the first node's value
        int i = 1;
        
        // Traverse the list
        while (current != null) {
            // Reservoir sampling: Replace result with current.val with probability 1/i
            if (rand.nextInt(i) == 0) {
                result = current.val;
            }
            current = current.next;
            i++;
        }
        
        return result;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
