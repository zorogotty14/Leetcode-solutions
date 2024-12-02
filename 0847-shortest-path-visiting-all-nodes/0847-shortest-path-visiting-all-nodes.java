import java.util.*;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int n = graph.length;

        // Special case: if there's only one node, the shortest path is 0
        if (n == 1) {
            return 0;
        }

        // Queue for BFS: stores (currentNode, visitedMask)
        Queue<int[]> queue = new LinkedList<>();
        // Set to keep track of visited states (node, visitedMask)
        Set<String> visited = new HashSet<>();

        // Initialize BFS with all nodes
        for (int i = 0; i < n; i++) {
            int mask = (1 << i); // Only the `i`-th node is visited
            queue.offer(new int[]{i, mask, 0}); // {currentNode, visitedMask, pathLength}
            visited.add(i + "," + mask);
        }

        // BFS traversal
        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int node = state[0];
            int mask = state[1];
            int pathLength = state[2];

            // If all nodes are visited, return the path length
            if (mask == (1 << n) - 1) {
                return pathLength;
            }

            // Explore neighbors
            for (int neighbor : graph[node]) {
                int nextMask = mask | (1 << neighbor); // Visit the neighbor
                String nextState = neighbor + "," + nextMask;

                if (!visited.contains(nextState)) {
                    visited.add(nextState);
                    queue.offer(new int[]{neighbor, nextMask, pathLength + 1});
                }
            }
        }

        // This should never be reached as the graph is connected
        return -1;
    }
}
