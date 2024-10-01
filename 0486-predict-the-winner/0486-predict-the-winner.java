class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        
        // Base cases: when there is only one element, the only option is to take that element.
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        
        // Fill the DP table for all subarrays of length > 1.
        for (int length = 2; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                // Player can either take the left or right element
                dp[left][right] = Math.max(nums[left] - dp[left + 1][right], nums[right] - dp[left][right - 1]);
            }
        }
        
        // If the value in dp[0][n-1] is non-negative, Player 1 can at least tie or win.
        return dp[0][n - 1] >= 0;
    }
}
