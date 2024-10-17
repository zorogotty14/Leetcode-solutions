class Solution {
    private static final int MOD = 1_000_000_007;

    public int checkRecord(int n) {
        // dp[i][A][L] = number of valid sequences of length i with A absences and ending with L lates
        long[][][] dp = new long[n + 1][2][3];

        // Base case: One valid sequence of length 0 (empty sequence)
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            // Case 1: Add 'P' to the sequence
            for (int A = 0; A <= 1; A++) {
                for (int L = 0; L <= 2; L++) {
                    dp[i][A][0] = (dp[i][A][0] + dp[i - 1][A][L]) % MOD;
                }
            }

            // Case 2: Add 'A' to the sequence (only if A < 1)
            for (int L = 0; L <= 2; L++) {
                dp[i][1][0] = (dp[i][1][0] + dp[i - 1][0][L]) % MOD;
            }

            // Case 3: Add 'L' to the sequence (only if L < 2)
            for (int A = 0; A <= 1; A++) {
                for (int L = 1; L <= 2; L++) {
                    dp[i][A][L] = (dp[i][A][L] + dp[i - 1][A][L - 1]) % MOD;
                }
            }
        }

        // Sum up all valid sequences of length n
        long result = 0;
        for (int A = 0; A <= 1; A++) {
            for (int L = 0; L <= 2; L++) {
                result = (result + dp[n][A][L]) % MOD;
            }
        }

        return (int) result;
    }
}
