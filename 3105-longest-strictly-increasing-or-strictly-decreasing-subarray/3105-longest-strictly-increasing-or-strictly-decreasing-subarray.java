class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        if (nums.length == 1) return 1;

        int maxLen = 1;
        int incLen = 1;
        int decLen = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                incLen++;
                decLen = 1;  // Reset decreasing subarray
            } else if (nums[i] < nums[i - 1]) {
                decLen++;
                incLen = 1;  // Reset increasing subarray
            } else {
                incLen = 1;  // Reset both if elements are equal
                decLen = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incLen, decLen));
        }

        return maxLen;
    }
}
