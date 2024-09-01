import java.util.HashMap;
import java.util.Map;

class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        UnionFind uf = new UnionFind(n);
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            int x = stones[i][0];
            int y = stones[i][1];
            
            // Union the current stone with the first stone found in the same row
            if (rowMap.containsKey(x)) {
                uf.union(i, rowMap.get(x));
            } else {
                rowMap.put(x, i);
            }
            
            // Union the current stone with the first stone found in the same column
            if (colMap.containsKey(y)) {
                uf.union(i, colMap.get(y));
            } else {
                colMap.put(y, i);
            }
        }
        
        return n - uf.getCount();
    }
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int count;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int p) {
            if (parent[p] != p) {
                parent[p] = find(parent[p]); // Path compression
            }
            return parent[p];
        }
        
        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP != rootQ) {
                if (rank[rootP] > rank[rootQ]) {
                    parent[rootQ] = rootP;
                } else if (rank[rootP] < rank[rootQ]) {
                    parent[rootP] = rootQ;
                } else {
                    parent[rootQ] = rootP;
                    rank[rootP]++;
                }
                count--; // Decrease the number of components
            }
        }
        
        public int getCount() {
            return count;
        }
    }
}
