class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Set initial distances based on edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // Floyd-Warshall algorithm to find shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Find the city with the smallest number of reachable cities within the distance threshold
        int minCount = Integer.MAX_VALUE;
        int resultCity = -1;

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] <= distanceThreshold && i != j) {
                    count++;
                }
            }
            if (count < minCount || (count == minCount && i > resultCity)) {
                minCount = count;
                resultCity = i;
            }
        }

        return resultCity;
    }
}