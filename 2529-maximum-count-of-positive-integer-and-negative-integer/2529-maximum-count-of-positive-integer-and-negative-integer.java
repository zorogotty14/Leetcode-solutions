class Solution {
    public int maximumCount(int[] nums) {
        int negCount = findFirstZeroOrPositive(nums);
        int posCount = nums.length - findFirstPositive(nums);
        return Math.max(negCount, posCount);
    }

    // Find the first index where nums[i] >= 0 (first zero or positive number)
    private int findFirstZeroOrPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid; // Move towards the first zero or positive
            } else {
                left = mid + 1;
            }
        }
        return left; // Count of negatives
    }

    // Find the first index where nums[i] > 0 (first positive number)
    private int findFirstPositive(int[] nums) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid; // Move towards the first positive
            } else {
                left = mid + 1;
            }
        }
        return left; // Count of zero and negatives
    }
}
