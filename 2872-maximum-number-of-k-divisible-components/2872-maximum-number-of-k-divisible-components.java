class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // Step 1: Build the adjacency list representation of the tree
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Step 2: Use a DFS helper function to calculate the subtree sums and count valid components
        int[] result = new int[1]; // To store the count of valid components
        dfs(0, -1, tree, values, k, result);
        return result[0];
    }

    private int dfs(int node, int parent, List<List<Integer>> tree, int[] values, int k, int[] result) {
        // Calculate the sum of the current subtree
        int currentSum = values[node];
        for (int neighbor : tree.get(node)) {
            if (neighbor != parent) {
                currentSum += dfs(neighbor, node, tree, values, k, result);
            }
        }

        // If the subtree sum is divisible by k, it forms a valid component
        if (currentSum % k == 0) {
            result[0]++;
            return 0; // Reset the sum for this subtree
        }

        // Otherwise, return the sum of the subtree to the parent
        return currentSum;
    }

}