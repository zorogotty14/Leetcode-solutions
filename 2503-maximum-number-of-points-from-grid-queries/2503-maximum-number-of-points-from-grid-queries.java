class Solution {
    // A simple DSU (Disjoint Set Union) or Union-Find structure
    static class DSU {
        int[] parent;
        int[] size;  // size[i] = size of the set whose root is i

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA != rootB) {
                if (size[rootA] < size[rootB]) {
                    int tmp = rootA;
                    rootA = rootB;
                    rootB = tmp;
                }
                // Attach smaller tree (rootB) to rootA
                parent[rootB] = rootA;
                size[rootA] += size[rootB];
            }
        }

        int getSize(int x) {
            int root = find(x);
            return size[root];
        }
    }

    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        // Flatten all cells into an array (value, row, col)
        // so we can sort them by their values.
        int[][] cells = new int[total][3];
        int idx = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                cells[idx][0] = grid[r][c];  // value
                cells[idx][1] = r;          // row
                cells[idx][2] = c;          // col
                idx++;
            }
        }
        // Sort cells in ascending order by cell-value
        java.util.Arrays.sort(cells, (a, b) -> a[0] - b[0]);

        // We need queries in ascending order but must remember their original indices
        int k = queries.length;
        int[][] queryWithIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryWithIndex[i][0] = queries[i];  // query value
            queryWithIndex[i][1] = i;           // original index
        }
        java.util.Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);

        // DSU for up to m*n cells
        DSU dsu = new DSU(total);

        // Function to convert (row, col) into DSU index
        java.util.function.BiFunction<Integer,Integer,Integer> toIndex =
            (r, c) -> r * n + c;

        // Keep track of which cell is "active" or not (initialized to false)
        boolean[] active = new boolean[total];

        // Offsets for neighbors (up, down, left, right)
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        int[] ans = new int[k];

        // We'll iterate through queries in ascending order,
        // "activating" cells whose values are < current query value.
        int cellPos = 0; // points to next cell to activate
        for (int i = 0; i < k; i++) {
            int qVal = queryWithIndex[i][0];
            int qIdx = queryWithIndex[i][1];

            // Activate all cells with value < qVal
            while (cellPos < total && cells[cellPos][0] < qVal) {
                int r = cells[cellPos][1];
                int c = cells[cellPos][2];
                int index = toIndex.apply(r, c);
                active[index] = true;

                // Union with any active neighbors
                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        int neighborIndex = toIndex.apply(nr, nc);
                        if (active[neighborIndex]) {
                            dsu.union(index, neighborIndex);
                        }
                    }
                }

                cellPos++;
            }

            // Now see if (0,0) is active. If not, we get 0.
            if (grid[0][0] >= qVal) {
                ans[qIdx] = 0;
            } else {
                // The component size of (0,0)'s DSU root
                int rootIndex = toIndex.apply(0, 0);
                ans[qIdx] = dsu.getSize(rootIndex);
            }
        }

        // 'ans' is correctly filled but in the order of queries' original indices
        return ans;
    }
}
