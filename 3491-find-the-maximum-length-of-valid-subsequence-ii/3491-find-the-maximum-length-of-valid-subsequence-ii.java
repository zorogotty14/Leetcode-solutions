class Solution {
    public int maximumLength(int[] nums, int k) {
       int maxLength = 0;

        // Iterate through all possible values of (sub[0] + sub[1]) % k
        for (int val = 0; val < k; val++) {
            int[] dp = new int[k];
            int localMaxLength = 0;

            for (int num : nums) {
                int currentMod = num % k;
                int previousMod = (val - currentMod + k) % k;

                if (dp[previousMod] > 0 || previousMod == val) {
                    dp[currentMod] = Math.max(dp[currentMod], dp[previousMod] + 1);
                } else {
                    dp[currentMod] = Math.max(dp[currentMod], 1);
                }

                localMaxLength = Math.max(localMaxLength, dp[currentMod]);
            }

            maxLength = Math.max(maxLength, localMaxLength);
        }

        return maxLength;
    }
}