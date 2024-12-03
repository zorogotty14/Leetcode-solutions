class Solution {
    public int largestCombination(int[] candidates) {
        // Initialize an array to count the number of 1s at each bit position (0-31).
        int[] bitCounts = new int[32];
        
        // Iterate through all numbers in candidates.
        for (int num : candidates) {
            // For each number, analyze its bits.
            for (int i = 0; i < 32; i++) {
                // Check if the ith bit is set.
                if ((num & (1 << i)) != 0) {
                    bitCounts[i]++;
                }
            }
        }
        
        // Find the maximum count across all bit positions.
        int maxCombinationSize = 0;
        for (int count : bitCounts) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }
        
        return maxCombinationSize;
    }
}
