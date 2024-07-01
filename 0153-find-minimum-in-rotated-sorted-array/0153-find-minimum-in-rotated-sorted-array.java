class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // The minimum is in the right part of the array
                left = mid + 1;
            } else {
                // The minimum is in the left part of the array, including mid
                right = mid;
            }
        }

        // The left index will be pointing to the minimum element
        return nums[left];
    }
}