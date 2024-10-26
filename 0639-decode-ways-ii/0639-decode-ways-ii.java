class Solution {
    private static final int MOD = 1_000_000_007;

    public int numDecodings(String s) {
        int n = s.length();
        // dp[i] represents the number of ways to decode s[0...i-1]
        long[] dp = new long[n + 1];

        // Base cases
        dp[0] = 1;  // One way to decode an empty string

        // Handle the first character
        dp[1] = waysToDecodeSingle(s.charAt(0));

        // Fill the dp array for the rest of the string
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);  // Current character
            char c2 = s.charAt(i - 2);  // Previous character

            // Single-character decoding for s[i-1]
            dp[i] = (dp[i] + dp[i - 1] * waysToDecodeSingle(c1)) % MOD;

            // Two-character decoding for s[i-2] and s[i-1]
            dp[i] = (dp[i] + dp[i - 2] * waysToDecodeDouble(c2, c1)) % MOD;
        }

        return (int) dp[n];
    }

    // Calculate the number of ways to decode a single character
    private int waysToDecodeSingle(char c) {
        if (c == '*') {
            return 9;  // '*' can represent any digit from '1' to '9'
        }
        if (c == '0') {
            return 0;  // '0' cannot represent any valid letter
        }
        return 1;  // Any other digit represents exactly one letter
    }

    // Calculate the number of ways to decode a two-character combination
    private int waysToDecodeDouble(char c1, char c2) {
        if (c1 == '*' && c2 == '*') {
            // "**" can represent any combination from "11" to "26"
            return 15;  // (1-9 and 10-26)
        } else if (c1 == '*') {
            // "*c2" where c2 is a digit
            if (c2 >= '0' && c2 <= '6') {
                return 2;  // "*c2" can represent "1c2" or "2c2"
            } else {
                return 1;  // "*c2" can only represent "1c2"
            }
        } else if (c2 == '*') {
            // "c1*" where c1 is a digit
            if (c1 == '1') {
                return 9;  // "1*" can represent "11" to "19"
            } else if (c1 == '2') {
                return 6;  // "2*" can represent "21" to "26"
            } else {
                return 0;  // Other digits cannot form a valid combination with '*'
            }
        } else {
            // Both c1 and c2 are digits
            int num = (c1 - '0') * 10 + (c2 - '0');  // Form the two-digit number
            if (num >= 10 && num <= 26) {
                return 1;  // Valid two-digit letter
            } else {
                return 0;  // Invalid two-digit letter
            }
        }
    }
}
