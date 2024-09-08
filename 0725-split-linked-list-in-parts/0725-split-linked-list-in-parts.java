class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1: Calculate the total length of the list
        ListNode current = head;
        int totalLength = 0;
        while (current != null) {
            totalLength++;
            current = current.next;
        }

        // Step 2: Determine the size of each part
        int partSize = totalLength / k;  // Base size of each part
        int remainder = totalLength % k; // Extra nodes to distribute
        
        // Step 3: Create an array to store the parts
        ListNode[] parts = new ListNode[k];
        
        current = head;
        for (int i = 0; i < k; i++) {
            parts[i] = current; // Start the current part
            int currentPartSize = partSize + (remainder > 0 ? 1 : 0); // Add an extra node if remainder > 0
            remainder--; // Use up one of the extra nodes
            
            // Step 4: Traverse the current part and disconnect it from the rest
            for (int j = 0; j < currentPartSize - 1; j++) {
                if (current != null) {
                    current = current.next;
                }
            }
            
            // Step 5: Disconnect the current part from the rest of the list
            if (current != null) {
                ListNode nextPart = current.next;
                current.next = null;
                current = nextPart;
            }
        }
        
        return parts;
    }
}
