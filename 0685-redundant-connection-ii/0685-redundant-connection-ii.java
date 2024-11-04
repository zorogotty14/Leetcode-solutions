class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] candidate1 = null;
        int[] candidate2 = null;
        
        // Step 1: Check for a node with two parents
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            if (parent[v] != 0) {
                // Node v has two parents
                candidate1 = new int[]{parent[v], v};
                candidate2 = edge;
            } else {
                parent[v] = u;
            }
        }
        
        // Step 2: Union-Find to detect cycles
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (edge == candidate2) continue; // Skip the invalid edge if any
            
            int u = edge[0];
            int v = edge[1];
            if (!uf.union(u, v)) {
                // Cycle detected
                if (candidate1 == null) return edge;
                return candidate1;
            }
        }
        
        // If no cycle is found, then return candidate2
        return candidate2;
    }
    
    // Helper class for Union-Find
    private class UnionFind {
        private int[] parent;
        
        public UnionFind(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int u, int v) {
            int rootU = find(u);
            int rootV = find(v);
            if (rootU == rootV) return false;
            parent[rootV] = rootU;
            return true;
        }
    }
}
