class Solution {
    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = true;
        boolean isDecreasing = true;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                isDecreasing = false; // Not decreasing
            }
            if (nums[i] < nums[i - 1]) {
                isIncreasing = false; // Not increasing
            }
        }

        // If either condition holds, return true
        return isIncreasing || isDecreasing;
    }
}
