class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int result = 0, count = 0, prevInvalidIndex = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > right) {
                // Current number invalidates all subarrays ending here
                count = 0;
                prevInvalidIndex = i;
            } else if (nums[i] >= left) {
                // Current number is within bounds
                count = i - prevInvalidIndex;
            }
            // Accumulate the valid subarray count
            result += count;
        }

        return result;
    }
}
