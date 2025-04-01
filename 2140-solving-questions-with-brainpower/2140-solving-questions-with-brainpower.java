class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        // dp[i] represents the maximum points we can earn starting from question i
        long[] dp = new long[n + 1];
        
        // Base case: dp[n] = 0 (no more questions to solve)
        
        // Fill dp array from the end
        for (int i = n - 1; i >= 0; i--) {
            int points = questions[i][0];
            int brainpower = questions[i][1];
            
            // Option 1: Skip the current question
            dp[i] = dp[i + 1];
            
            // Option 2: Solve the current question
            int nextIndex = Math.min(i + brainpower + 1, n);
            dp[i] = Math.max(dp[i], points + dp[nextIndex]);
        }
        
        // Return the maximum points starting from the first question
        return dp[0];
    }
}