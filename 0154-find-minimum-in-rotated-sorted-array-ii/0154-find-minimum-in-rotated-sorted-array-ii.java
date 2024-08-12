class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] < nums[right]) {
                right = mid; // The min is in the left part (including mid)
            } else if (nums[mid] > nums[right]) {
                left = mid + 1; // The min is in the right part
            } else {
                right--; // Move the right pointer down to skip the duplicate
            }
        }
        
        return nums[left];
    }
}