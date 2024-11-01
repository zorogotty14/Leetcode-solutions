class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;

        int maxLength = 1;
        int currentLength = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currentLength++;
            } else {
                maxLength = Math.max(maxLength, currentLength);
                currentLength = 1; // reset the current length
            }
        }
        
        // Final check in case the longest LCIS is at the end of the array
        return Math.max(maxLength, currentLength);
    }
}
