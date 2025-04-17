class Solution {
    public int countPairs(int[] nums, int k) {
        int count = 0;
        int n = nums.length;
        
        // Check all possible pairs (i, j) where i < j
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                // Check if nums[i] == nums[j] and (i * j) is divisible by k
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        
        return count;
    }
}