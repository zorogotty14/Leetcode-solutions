import java.util.*;

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        // Step 1: Graph representation & DSU initialization
        DSU dsu = new DSU(n);

        // Step 2: Process edges using DSU to track minimum AND-cost per component
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dsu.union(u, v, w);
        }

        // Step 3: Process queries
        int[] result = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int s = query[i][0], t = query[i][1];

            if (dsu.find(s) != dsu.find(t)) {
                result[i] = -1; // Nodes belong to different components
            } else {
                result[i] = dsu.getMinCost(s); // Get the stored min AND-cost
            }
        }

        return result;
    }
}

// DSU (Disjoint Set Union) with path compression and union by rank
class DSU {
    int[] parent, rank, minAndCost;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        minAndCost = new int[n];
        Arrays.fill(minAndCost, -1);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y, int weight) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX == rootY) {
            minAndCost[rootX] &= weight;
            return;
        }

        if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
            minAndCost[rootX] = (minAndCost[rootX] == -1) ? weight : (minAndCost[rootX] & weight);
        } else if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
            minAndCost[rootY] = (minAndCost[rootY] == -1) ? weight : (minAndCost[rootY] & weight);
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
            minAndCost[rootX] = (minAndCost[rootX] == -1) ? weight : (minAndCost[rootX] & weight);
        }
    }

    public int getMinCost(int x) {
        return minAndCost[find(x)];
    }
}
