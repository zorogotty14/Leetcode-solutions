class Solution {
    public int numTilings(int n) {
        // Modulo constant
        int MOD = 1_000_000_007;

        // Base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Arrays to store dp and f values
        long[] dp = new long[n + 1];
        long[] f = new long[n + 1];

        // Initialize base cases
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        f[1] = 0;
        f[2] = 1;

        // Fill dp and f arrays
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] + dp[i - 2]) % MOD;
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * f[i - 1]) % MOD;
        }

        return (int) dp[n];
    }
}
