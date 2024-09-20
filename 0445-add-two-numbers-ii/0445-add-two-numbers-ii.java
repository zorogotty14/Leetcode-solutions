/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Initialize two stacks to hold the digits
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // Push all digits of l1 onto stack1
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }

        // Push all digits of l2 onto stack2
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode head = null; // Resulting list
        int carry = 0; // Carry-over value

        // Process the stacks and carry
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;

            // Add top elements of the stacks if available
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }

            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }

            // Update carry for next iteration
            carry = sum / 10;

            // Create a new node and add it to the front of the list
            ListNode newNode = new ListNode(sum % 10);
            newNode.next = head;
            head = newNode;
        }

        return head;
    }
}
