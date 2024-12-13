class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        final int MOD = 1_000_000_007;

        // Calculate the Least Common Multiple (LCM) of a and b
        long lcm = (long) a * b / gcd(a, b);

        long left = 1, right = (long) n * Math.min(a, b);
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (mid / a + mid / b - mid / lcm < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (int) (left % MOD);
    }

    private int gcd(int x, int y) {
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        // Base case: When there is only one pile to pick
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        // Fill the DP table for ranges of increasing size
        for (int size = 2; size <= n; size++) {
            for (int i = 0; i <= n - size; i++) {
                int j = i + size - 1;
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }

        // If the score difference is positive, Alice wins
        return dp[0][n - 1] > 0;
    }
}
