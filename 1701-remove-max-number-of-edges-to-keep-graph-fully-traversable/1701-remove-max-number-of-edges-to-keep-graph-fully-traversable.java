class Solution {
    class DSU {
        int[] parent, rank;
        
        public DSU(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        
        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                } else {
                    parent[rootY] = rootX;
                    rank[rootX]++;
                }
                return true;
            }
            return false;
        }
    }
    
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DSU aliceDSU = new DSU(n + 1);
        DSU bobDSU = new DSU(n + 1);
        
        int totalEdgesUsed = 0;
        
        // First pass: handle type 3 edges
        for (int[] edge : edges) {
            if (edge[0] == 3) {
                boolean aliceUnion = aliceDSU.union(edge[1], edge[2]);
                boolean bobUnion = bobDSU.union(edge[1], edge[2]);
                if (aliceUnion || bobUnion) {
                    totalEdgesUsed++;
                }
            }
        }
        
        // Second pass: handle type 1 and type 2 edges
        for (int[] edge : edges) {
            if (edge[0] == 1) {
                if (aliceDSU.union(edge[1], edge[2])) {
                    totalEdgesUsed++;
                }
            } else if (edge[0] == 2) {
                if (bobDSU.union(edge[1], edge[2])) {
                    totalEdgesUsed++;
                }
            }
        }
        
        // Check if both Alice and Bob can fully traverse the graph
        if (!allNodesConnected(aliceDSU, n) || !allNodesConnected(bobDSU, n)) {
            return -1;
        }
        
        return edges.length - totalEdgesUsed;
    }
    
    private boolean allNodesConnected(DSU dsu, int n) {
        int root = dsu.find(1);
        for (int i = 2; i <= n; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }
        return true;
    }
}