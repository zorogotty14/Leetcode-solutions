
class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long maxValue = 0;
        
        // We need O(n) solution to avoid TLE
        
        // maxDiff will track the maximum (nums[i] - nums[j]) seen so far
        int maxDiff = 0;
        
        // maxNum will track the maximum nums[i] seen so far
        int maxNum = 0;
        
        for (int k = 0; k < n; k++) {
            // Calculate the maximum triplet value ending at current index k
            // maxDiff already contains the maximum (nums[i] - nums[j]) for i < j < k
            maxValue = Math.max(maxValue, (long) maxDiff * nums[k]);
            
            // Update maxDiff for the next iteration
            // Current number can be used as nums[j] with maxNum as nums[i]
            maxDiff = Math.max(maxDiff, maxNum - nums[k]);
            
            // Update maxNum to possibly use current number as nums[i] in future
            maxNum = Math.max(maxNum, nums[k]);
        }
        
        return maxValue;
    }
}