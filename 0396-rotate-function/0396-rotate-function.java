class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;  // Sum of all elements in nums
        int F = 0;    // Initial F(0)
        
        // Compute sum of all elements and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }
        
        // Initialize max value as F(0)
        int maxF = F;
        
        // Compute F(k) for k = 1 to n-1
        for (int k = 1; k < n; k++) {
            F = F + sum - n * nums[n - k];  // Transition from F(k-1) to F(k)
            maxF = Math.max(maxF, F);
        }
        
        return maxF;
    }
}
