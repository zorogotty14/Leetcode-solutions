class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];  // Tracks visited cities
        int provinceCount = 0;

        // Iterate through each city
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {  // If the city is not visited, it starts a new province
                dfs(isConnected, visited, i);
                provinceCount++;  // Increment the province count
            }
        }
        
        return provinceCount;
    }
    
    // Helper DFS function to visit all connected cities
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;  // Mark the current city as visited
        
        // Explore all cities connected to the current city
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(isConnected, visited, i);  // Recursively visit connected cities
            }
        }
    }
}
