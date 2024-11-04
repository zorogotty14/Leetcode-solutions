class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        
        // Initialize each node to be its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
        
        // Process each edge
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            // If union fails, it means this edge is redundant
            if (!union(u, v, parent, rank)) {
                return edge;
            }
        }
        
        return new int[0];
    }
    
    // Find with path compression
    private int find(int node, int[] parent) {
        if (parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }
        return parent[node];
    }
    
    // Union by rank
    private boolean union(int u, int v, int[] parent, int[] rank) {
        int rootU = find(u, parent);
        int rootV = find(v, parent);
        
        if (rootU == rootV) return false; // u and v are already connected, indicating a cycle
        
        // Union by rank
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++;
        }
        return true;
    }
}
