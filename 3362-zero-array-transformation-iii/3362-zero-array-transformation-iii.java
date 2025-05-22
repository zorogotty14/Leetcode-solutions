class Solution {
    public int maxRemoval(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        
        // First check if it's possible to convert to zero array using all queries
        if (!canConvertToZero(nums, queries)) {
            return -1;
        }
        
        // Binary search on the number of queries to remove
        int left = 0, right = m;
        int result = 0;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canRemoveQueries(nums, queries, mid)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    private boolean canRemoveQueries(int[] nums, int[][] queries, int removeCount) {
        // Try all combinations of removing removeCount queries
        // This is computationally expensive for large inputs, so we use a greedy approach
        
        // For efficiency, we'll use a greedy strategy:
        // Remove queries that contribute least to making the array zero
        
        int m = queries.length;
        boolean[] removed = new boolean[m];
        
        // Calculate contribution of each query
        int[] contribution = new int[m];
        for (int i = 0; i < m; i++) {
            contribution[i] = calculateContribution(nums, queries[i]);
        }
        
        // Sort queries by contribution (ascending) and remove the least contributing ones
        Integer[] indices = new Integer[m];
        for (int i = 0; i < m; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (a, b) -> Integer.compare(contribution[a], contribution[b]));
        
        // Mark queries to remove
        for (int i = 0; i < removeCount; i++) {
            removed[indices[i]] = true;
        }
        
        // Check if remaining queries can convert array to zero
        int[][] remainingQueries = new int[m - removeCount][];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            if (!removed[i]) {
                remainingQueries[idx++] = queries[i];
            }
        }
        
        return canConvertToZero(nums, remainingQueries);
    }
    
    private int calculateContribution(int[] nums, int[] query) {
        int left = query[0];
        int right = query[1];
        int contribution = 0;
        
        for (int i = left; i <= right; i++) {
            if (nums[i] > 0) {
                contribution++;
            }
        }
        
        return contribution;
    }
    
    private boolean canConvertToZero(int[] nums, int[][] queries) {
        int n = nums.length;
        
        // Use difference array to efficiently calculate coverage
        long[] diff = new long[n + 1];
        
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            diff[left]++;
            diff[right + 1]--;
        }
        
        // Calculate prefix sum to get coverage at each position
        long[] coverage = new long[n];
        long prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
            coverage[i] = prefixSum;
        }
        
        // Check if each element can be decremented to zero
        for (int i = 0; i < n; i++) {
            if (nums[i] > coverage[i]) {
                return false;
            }
        }
        
        return true;
    }
}