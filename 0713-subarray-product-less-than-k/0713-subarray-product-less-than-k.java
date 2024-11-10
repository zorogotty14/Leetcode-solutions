class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0; // If k is 0 or 1, no product can be less than k

        int count = 0;
        int product = 1;
        int left = 0;

        // Use a sliding window approach
        for (int right = 0; right < nums.length; right++) {
            product *= nums[right];

            // Shrink the window from the left until the product is less than k
            while (product >= k) {
                product /= nums[left];
                left++;
            }

            // The number of subarrays ending at index 'right' is (right - left + 1)
            count += right - left + 1;
        }

        return count;
    }
}
