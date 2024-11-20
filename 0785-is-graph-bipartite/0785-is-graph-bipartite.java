import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // 0: uncolored, 1: color 1, -1: color 2

        for (int i = 0; i < n; i++) {
            if (colors[i] != 0) {
                continue; // Skip already colored nodes
            }

            // Start BFS for each connected component
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            colors[i] = 1; // Assign an initial color

            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int neighbor : graph[node]) {
                    if (colors[neighbor] == 0) {
                        // Color the neighbor with the opposite color
                        colors[neighbor] = -colors[node];
                        queue.offer(neighbor);
                    } else if (colors[neighbor] == colors[node]) {
                        // If the neighbor has the same color, it's not bipartite
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
