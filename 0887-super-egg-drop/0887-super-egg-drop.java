class Solution {
    public int superEggDrop(int k, int n) {
        // dp[m][k]: Maximum floors we can test with m moves and k eggs
        int[] dp = new int[k + 1];
        int moves = 0;

        while (dp[k] < n) {
            moves++;
            for (int eggs = k; eggs > 0; eggs--) {
                dp[eggs] = dp[eggs] + dp[eggs - 1] + 1;
            }
        }

        return moves;
    }
}
