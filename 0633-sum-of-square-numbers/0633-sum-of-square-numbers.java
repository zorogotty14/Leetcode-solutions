class Solution {
    public boolean judgeSquareSum(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);  // Start from the square root of c

        while (left <= right) {
            long sum = (long) left * left + (long) right * right;  // Use long to avoid overflow

            if (sum == c) {
                return true;  // Found two integers a and b
            } else if (sum < c) {
                left++;  // Increase the sum by moving the left pointer
            } else {
                right--;  // Decrease the sum by moving the right pointer
            }
        }

        return false;  // No such pair found
    }
}
