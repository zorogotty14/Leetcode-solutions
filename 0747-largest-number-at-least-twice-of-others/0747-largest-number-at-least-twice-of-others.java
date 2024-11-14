class Solution {
    public int dominantIndex(int[] nums) {
        // Find the largest element and its index
        int maxIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        
        // Check if the largest element is at least twice as large as every other element
        for (int i = 0; i < nums.length; i++) {
            if (i != maxIndex && nums[maxIndex] < 2 * nums[i]) {
                return -1;
            }
        }
        
        return maxIndex;
    }
}
