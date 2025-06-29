class Solution {
    public int numSubseq(int[] nums, int target) {
        int MOD = 1000000007;
        int n = nums.length;
        
        // Sort the array to use two pointers
        Arrays.sort(nums);
        
        // Precompute powers of 2 to avoid repeated calculation
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int i = 1; i < n; i++) {
            pow2[i] = (pow2[i-1] * 2) % MOD;
        }
        
        int left = 0, right = n - 1;
        int result = 0;
        
        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All subsequences with nums[left] as minimum
                // and maximum between left and right are valid
                result = (result + pow2[right - left]) % MOD;
                left++;
            } else {
                // nums[right] is too large, try smaller maximum
                right--;
            }
        }
        
        return result;
    }
}