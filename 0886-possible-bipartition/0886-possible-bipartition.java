import java.util.*;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Build the graph as an adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]].add(dislike[1]);
            graph[dislike[1]].add(dislike[0]);
        }

        // Array to store the color of each node (0 = uncolored, 1 = group A, -1 = group B)
        int[] color = new int[n + 1];

        // Check bipartition for each connected component
        for (int i = 1; i <= n; i++) {
            if (color[i] == 0) { // If not yet visited
                if (!bfsCheck(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean bfsCheck(List<Integer>[] graph, int[] color, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        color[start] = 1; // Assign the first group

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) {
                    // Assign the opposite color to the neighbor
                    color[neighbor] = -color[node];
                    queue.offer(neighbor);
                } else if (color[neighbor] == color[node]) {
                    // If the neighbor has the same color as the current node, not bipartite
                    return false;
                }
            }
        }

        return true;
    }
}
