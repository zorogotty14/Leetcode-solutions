class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int maxDiff = -1;
        int minSoFar = nums[0];
        
        for (int j = 1; j < n; j++) {
            // If current element is greater than minimum seen so far
            if (nums[j] > minSoFar) {
                maxDiff = Math.max(maxDiff, nums[j] - minSoFar);
            }
            // Update minimum seen so far
            minSoFar = Math.min(minSoFar, nums[j]);
        }
        
        return maxDiff;
    }
}