class Solution {
    public int findKthNumber(int n, int k) {
        long curr = 1; // Start from number 1
        k--; // Decrement k because we start from the first number

        while (k > 0) {
            long steps = calculateSteps(n, curr, curr + 1);

            if (steps <= k) {
                // Move to the next sibling
                curr += 1;
                k -= steps;
            } else {
                // Move to the first child
                curr *= 10;
                k -= 1; // Move to the next number
            }
        }

        return (int) curr;
    }

    // Helper method to calculate the steps between curr and next
    private long calculateSteps(long n, long curr, long next) {
        long steps = 0;

        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;
            curr *= 10;
            next *= 10;
        }

        return steps;
    }
}
