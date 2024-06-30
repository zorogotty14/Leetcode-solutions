class Solution {
    public int findPeakElement(int[] nums) {
       int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // The peak is in the left half including mid
                right = mid;
            } else {
                // The peak is in the right half excluding mid
                left = mid + 1;
            }
        }

        // Left should be the peak element
        return left;  
    }
}