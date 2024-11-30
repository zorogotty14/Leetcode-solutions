class Solution {
    private int[] parent; // Make parent an instance variable

    // Union-Find helper methods
    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY;
        }
    }

    // Helper to check if two strings are similar
    private boolean isSimilar(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 2) return false;
            }
        }
        return true;
    }

    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Union similar strings
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isSimilar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }

        // Count the number of unique groups
        int groups = 0;
        for (int i = 0; i < n; i++) {
            if (find(i) == i) {
                groups++;
            }
        }

        return groups;
    }
}
