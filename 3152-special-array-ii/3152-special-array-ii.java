class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        boolean[] result = new boolean[m];

        // Step 1: Compute parity difference
        boolean[] parityDiff = new boolean[n - 1];
        for (int i = 0; i < n - 1; i++) {
            parityDiff[i] = (nums[i] % 2 != nums[i + 1] % 2);
        }

        // Step 2: Compute prefix sum
        int[] prefixSum = new int[n];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (parityDiff[i - 1] ? 1 : 0);
        }

        // Step 3: Process each query
        for (int i = 0; i < m; i++) {
            int from = queries[i][0];
            int to = queries[i][1];

            // If the range contains less than 2 elements, it is special
            if (to - from < 1) {
                result[i] = true;
                continue;
            }

            // Calculate the number of parity-different pairs in the range
            int totalPairs = to - from;
            int diffCount = prefixSum[to] - prefixSum[from];

            // If all pairs in the range have different parities, it is special
            result[i] = (diffCount == totalPairs);
        }

        return result;
    }
}
