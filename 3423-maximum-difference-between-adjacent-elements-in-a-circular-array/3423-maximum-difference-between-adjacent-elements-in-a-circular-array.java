class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        
        // Check all consecutive adjacent pairs
        for (int i = 0; i < n - 1; i++) {
            int diff = Math.abs(nums[i] - nums[i + 1]);
            maxDiff = Math.max(maxDiff, diff);
        }
        
        // Check the circular pair (last and first elements)
        int circularDiff = Math.abs(nums[n - 1] - nums[0]);
        maxDiff = Math.max(maxDiff, circularDiff);
        
        return maxDiff;
    }
}