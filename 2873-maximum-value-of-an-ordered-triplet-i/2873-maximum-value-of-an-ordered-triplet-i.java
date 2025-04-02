class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        long result = 0;
        
        // Find the maximum triplet value by checking all possible combinations
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    // Calculate the value for current triplet (i,j,k)
                    long value = (long)(nums[i] - nums[j]) * nums[k];
                    // Update the maximum value
                    result = Math.max(result, value);
                }
            }
        }
        
        return result;
    }
}