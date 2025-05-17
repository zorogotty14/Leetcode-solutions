class Solution {
    public void sortColors(int[] nums) {
        // Initialize three pointers
        int low = 0;        // for 0s (red)
        int mid = 0;        // for 1s (white)
        int high = nums.length - 1; // for 2s (blue)
        
        // One-pass algorithm
        while (mid <= high) {
            switch (nums[mid]) {
                case 0: // Red
                    // Swap the element at mid with the element at low
                    swap(nums, low, mid);
                    low++;
                    mid++;
                    break;
                    
                case 1: // White
                    // Element is already at right position, just move pointer
                    mid++;
                    break;
                    
                case 2: // Blue
                    // Swap the element at mid with the element at high
                    swap(nums, mid, high);
                    high--;
                    // Note: mid is not incremented here because the swapped element 
                    // from high needs to be processed in the next iteration
                    break;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}