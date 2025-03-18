class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0, bitmask = 0, maxLen = 0;
        
        for (int right = 0; right < nums.length; right++) {
            // While there is a conflict, remove elements from left
            while ((bitmask & nums[right]) != 0) {
                bitmask ^= nums[left];  // Remove nums[left] from bitmask
                left++;
            }
            
            // Add nums[right] to bitmask
            bitmask |= nums[right];
            
            // Update max length
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}
