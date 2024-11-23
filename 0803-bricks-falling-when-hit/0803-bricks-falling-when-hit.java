class Solution {
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[hits.length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Copy grid and apply hits
        int[][] modifiedGrid = new int[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(grid[i], 0, modifiedGrid[i], 0, n);
        }
        for (int[] hit : hits) {
            modifiedGrid[hit[0]][hit[1]] = 0;
        }
        
        // Union-Find setup
        int size = m * n;
        UnionFind uf = new UnionFind(size + 1); // Extra node for the roof
        int roof = size; // Index for the roof node
        
        // Connect stable bricks
        for (int j = 0; j < n; j++) {
            if (modifiedGrid[0][j] == 1) {
                uf.union(j, roof);
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (modifiedGrid[i][j] == 1) {
                    if (i > 0 && modifiedGrid[i - 1][j] == 1) {
                        uf.union(i * n + j, (i - 1) * n + j);
                    }
                    if (j > 0 && modifiedGrid[i][j - 1] == 1) {
                        uf.union(i * n + j, i * n + j - 1);
                    }
                }
            }
        }
        
        // Process hits in reverse
        for (int k = hits.length - 1; k >= 0; k--) {
            int row = hits[k][0], col = hits[k][1];
            if (grid[row][col] == 0) {
                result[k] = 0;
                continue;
            }
            
            int preRoofSize = uf.size(roof);
            
            // Re-add the brick
            modifiedGrid[row][col] = 1;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && modifiedGrid[newRow][newCol] == 1) {
                    uf.union(row * n + col, newRow * n + newCol);
                }
            }
            if (row == 0) {
                uf.union(col, roof);
            }
            
            // Calculate the difference in roof size
            int postRoofSize = uf.size(roof);
            result[k] = Math.max(0, postRoofSize - preRoofSize - 1); // Exclude the newly added brick
        }
        
        return result;
    }
    
    // Union-Find class
    static class UnionFind {
        int[] parent, rank, size;
        
        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }
        
        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]); // Path compression
            }
            return parent[x];
        }
        
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] > rank[rootY]) {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                } else if (rank[rootX] < rank[rootY]) {
                    parent[rootX] = rootY;
                    size[rootY] += size[rootX];
                } else {
                    parent[rootY] = rootX;
                    size[rootX] += size[rootY];
                    rank[rootX]++;
                }
            }
        }
        
        public int size(int x) {
            return size[find(x)];
        }
    }
}
