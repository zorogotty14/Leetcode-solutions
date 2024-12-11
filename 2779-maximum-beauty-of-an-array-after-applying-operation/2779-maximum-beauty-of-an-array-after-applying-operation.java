import java.util.Arrays;

class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array to make it easier to find subsequences
        Arrays.sort(nums);
        
        int n = nums.length;
        int maxBeauty = 0;
        int left = 0;

        // Use a sliding window to find the maximum subsequence where all elements
        // can be adjusted to be the same value
        for (int right = 0; right < n; right++) {
            // Check if the current window is valid
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            
            // Update the maximum beauty (length of the current valid window)
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
