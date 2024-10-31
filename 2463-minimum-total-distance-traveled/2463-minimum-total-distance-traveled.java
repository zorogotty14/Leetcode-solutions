import java.util.Arrays;
import java.util.List;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;
        
        // Sort robots and factories by position
        robot.sort(Integer::compareTo);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));
        
        // DP array: dp[i][j] will store the minimum distance for the first i robots and j factories
        long[][] dp = new long[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0; // base case: no robots, no factories
        
        for (int j = 1; j <= m; j++) { // for each factory
            dp[0][j] = 0; // no robots, no distance needed
            int position = factory[j - 1][0];
            int limit = factory[j - 1][1];
            
            // Consider sending up to 'limit' robots to factory j-1
            for (int i = 1; i <= n; i++) {
                long totalCost = 0;
                
                // Try to assign up to 'limit' robots to this factory
                for (int k = 0; k < Math.min(limit, i); k++) {
                    totalCost += Math.abs(robot.get(i - k - 1) - position);
                    if (dp[i - k - 1][j - 1] != Long.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - k - 1][j - 1] + totalCost);
                    }
                }
                
                // In case we skip this factory for current 'i' robots, carry the previous result
                dp[i][j] = Math.min(dp[i][j], dp[i][j - 1]);
            }
        }
        
        // The answer for all robots using all factories
        return dp[n][m];
    }
}
