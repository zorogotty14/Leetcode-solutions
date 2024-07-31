class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: an empty string has one way to be decoded

        for (int i = 1; i <= n; i++) {
            // Single digit decode
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }

            // Two digits decode
            if (i > 1) {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        return dp[n];
    }
}