class Solution {
    public int minimizeMax(int[] nums, int p) {
        if (p == 0) return 0;
        
        Arrays.sort(nums);
        int n = nums.length;
        
        // Binary search on the answer
        int left = 0;
        int right = nums[n - 1] - nums[0]; // Maximum possible difference
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (canFormPairs(nums, p, mid)) {
                right = mid; // Try to find smaller maximum difference
            } else {
                left = mid + 1; // Need larger maximum difference
            }
        }
        
        return left;
    }
    
    // Check if we can form p pairs with maximum difference <= maxDiff
    private boolean canFormPairs(int[] nums, int p, int maxDiff) {
        int pairs = 0;
        int i = 0;
        
        while (i < nums.length - 1 && pairs < p) {
            // If current adjacent pair has difference <= maxDiff, form a pair
            if (nums[i + 1] - nums[i] <= maxDiff) {
                pairs++;
                i += 2; // Skip both elements as they are now paired
            } else {
                i++; // Move to next element
            }
        }
        
        return pairs >= p;
    }
}