class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int left = -1, right = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

        // Find the right boundary where the order breaks from left to right
        for (int i = 0; i < n; i++) {
            if (nums[i] < max) {
                right = i;
            } else {
                max = nums[i];
            }
        }

        // Find the left boundary where the order breaks from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] > min) {
                left = i;
            } else {
                min = nums[i];
            }
        }

        // If no boundaries were found, the array is already sorted
        return (left == -1) ? 0 : (right - left + 1);
    }
}
