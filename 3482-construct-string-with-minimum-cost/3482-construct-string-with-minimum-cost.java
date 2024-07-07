class Solution {
    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue;
            for (int j = 0; j < words.length; j++) {
                String word = words[j];
                int cost = costs[j];
                int len = word.length();
                if (i + len <= n && target.substring(i, i + len).equals(word)) {
                    dp[i + len] = Math.min(dp[i + len], dp[i] + cost);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}