class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int n = nums.length;

        // Step 1: Find the maximum possible OR of all elements combined.
        for (int num : nums) {
            maxOr |= num;
        }

        int count = 0;

        // Step 2: Use bitmasking to generate all subsets.
        for (int mask = 1; mask < (1 << n); mask++) {
            int currentOr = 0;

            // Step 3: Calculate the OR for the current subset.
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }

            // Step 4: Check if the OR equals the maximum OR.
            if (currentOr == maxOr) {
                count++;
            }
        }

        // Step 5: Return the count of subsets with the maximum OR.
        return count;
    }
}
