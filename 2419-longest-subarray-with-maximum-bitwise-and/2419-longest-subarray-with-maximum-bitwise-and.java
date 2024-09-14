class Solution {
    public int longestSubarray(int[] nums) {
        // Step 1: Find the maximum value in the array
        int maxVal = Integer.MIN_VALUE;
        for (int num : nums) {
            maxVal = Math.max(maxVal, num);
        }

        // Step 2: Find the longest subarray where all elements are equal to the maximum value
        int longest = 0;
        int currentLength = 0;
        
        for (int num : nums) {
            if (num == maxVal) {
                currentLength++;  // If the element is equal to maxVal, increase the current subarray length
                longest = Math.max(longest, currentLength);  // Track the longest subarray
            } else {
                currentLength = 0;  // Reset the current subarray length if the element is not maxVal
            }
        }
        
        return longest;  // Return the length of the longest subarray
    }
}
