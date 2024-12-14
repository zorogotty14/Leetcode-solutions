class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long count = 0;

        // Sliding window pointers
        int left = 0;

        // Variables to keep track of the min and max in the current window
        int min = nums[0], max = nums[0];

        for (int right = 0; right < n; right++) {
            // Update the min and max for the current window
            min = Math.min(min, nums[right]);
            max = Math.max(max, nums[right]);

            // Check if the current window is valid
            while (max - min > 2) {
                // Slide the window to the right
                left++;
                min = nums[left];
                max = nums[left];
                for (int i = left; i <= right; i++) {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                }
            }

            // Add the number of subarrays ending at 'right'
            count += (right - left + 1);
        }

        return count;
    }
}
