class Solution {
    public int partitionArray(int[] nums, int k) {
        // Sort the array to process elements in order
        Arrays.sort(nums);
        
        int subsequences = 1; // At least one subsequence needed
        int minInCurrentSubseq = nums[0]; // Track minimum of current subsequence
        
        // Iterate through sorted array starting from second element
        for (int i = 1; i < nums.length; i++) {
            // If current element can't fit in current subsequence
            if (nums[i] - minInCurrentSubseq > k) {
                // Start a new subsequence
                subsequences++;
                minInCurrentSubseq = nums[i];
            }
            // If it can fit, we don't need to do anything
            // (nums[i] - minInCurrentSubseq <= k, so continue with current subsequence)
        }
        
        return subsequences;
    }
}