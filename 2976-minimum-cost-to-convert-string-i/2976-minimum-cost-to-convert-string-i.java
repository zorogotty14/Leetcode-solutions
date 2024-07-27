class Solution {
    private static final int INF = Integer.MAX_VALUE / 2;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = source.length();
        int[][] dist = new int[26][26];
        
        // Initialize distances with infinity
        for (int i = 0; i < 26; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        // Fill in given transformation costs
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            dist[from][to] = Math.min(dist[from][to], cost[i]);
        }
        
        // Use Floyd-Warshall to compute the shortest paths between all pairs of characters
        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        
        long totalCost = 0;
        
        // Compute the total transformation cost
        for (int i = 0; i < n; i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (dist[from][to] == INF) {
                return -1;  // Transformation is impossible
            }
            totalCost += dist[from][to];
        }
        
        return totalCost;
    }
}