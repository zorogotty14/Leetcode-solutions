class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1, right = 0;
        
        // Find the maximum number of products in any type to set the upper bound
        for (int q : quantities) {
            right = Math.max(right, q);
        }
        
        // Binary search for the minimum possible maximum products a store can get
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDistribute(mid, n, quantities)) {
                right = mid; // Try to minimize further
            } else {
                left = mid + 1; // Increase minimum threshold
            }
        }
        
        return left;
    }
    
    private boolean canDistribute(int maxProductsPerStore, int n, int[] quantities) {
        int storesNeeded = 0;
        for (int q : quantities) {
            storesNeeded += (q + maxProductsPerStore - 1) / maxProductsPerStore; // Equivalent to ceiling(q / maxProductsPerStore)
        }
        return storesNeeded <= n;
    }
}
