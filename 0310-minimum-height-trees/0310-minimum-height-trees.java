import java.util.*;

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        // Edge case: if there's only one node, it's the root of the MHT
        if (n == 1) return Collections.singletonList(0);
        
        // Step 1: Build the adjacency list for the graph
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new HashSet<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // Step 2: Initialize the first layer of leaves
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1) {
                leaves.add(i);
            }
        }
        
        // Step 3: Trim the leaves layer by layer
        while (n > 2) {
            n -= leaves.size(); // Reduce the number of nodes left
            List<Integer> newLeaves = new ArrayList<>();
            
            for (int leaf : leaves) {
                int neighbor = adj.get(leaf).iterator().next(); // Get the only neighbor
                adj.get(neighbor).remove(leaf);
                if (adj.get(neighbor).size() == 1) {
                    newLeaves.add(neighbor);
                }
            }
            
            leaves = newLeaves;
        }
        
        // The remaining nodes are the roots of the MHTs
        return leaves;
    }
}
