class Solution {
    public int lastRemaining(int n) {
        int head = 1;        // The current first element
        int step = 1;        // The step size between remaining elements
        int remaining = n;   // The number of remaining elements
        boolean left = true; // Direction of elimination
        
        while (remaining > 1) {
            // Move the head if we're eliminating from left, or if we're eliminating from right with an odd number of elements
            if (left || remaining % 2 == 1) {
                head += step;
            }
            // Halve the number of remaining elements and double the step size
            remaining /= 2;
            step *= 2;
            // Alternate the direction
            left = !left;
        }
        
        return head;
    }
}
