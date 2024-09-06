import java.util.*;

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Initialize DP arrays
        int[] dp = new int[n]; // dp[i] will store the size of the largest subset ending with nums[i]
        int[] parent = new int[n]; // parent[i] will store the index of the previous element in the subset
        Arrays.fill(dp, 1); // Each number is a subset of size 1 by default
        Arrays.fill(parent, -1); // Initialize parent array

        int maxSize = 1; // Track the size of the largest subset
        int maxIndex = 0; // Track the index of the last element in the largest subset

        // Step 3: Build DP array
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                }
            }
            // Update the maxSize and maxIndex if we found a larger subset
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        // Step 4: Reconstruct the subset
        List<Integer> result = new ArrayList<>();
        int current = maxIndex;
        while (current != -1) {
            result.add(nums[current]);
            current = parent[current];
        }

        // The subset is constructed in reverse order, so reverse it
        Collections.reverse(result);

        return result;
    }
}
