class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;

        // Step 1: Calculate the total sum of the array
        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Iterate through the array and calculate prefix sums
        long prefixSum = 0;
        int validSplits = 0;

        for (int i = 0; i < n - 1; i++) {
            prefixSum += nums[i];
            long suffixSum = totalSum - prefixSum;

            // Step 3: Check if the split is valid
            if (prefixSum >= suffixSum) {
                validSplits++;
            }
        }

        return validSplits;
    }
}
