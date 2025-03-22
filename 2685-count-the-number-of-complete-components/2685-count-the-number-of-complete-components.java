import java.util.*;

class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        // Step 1: Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        // Step 2: Traverse each component
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                // Use BFS or DFS to find all nodes in this component
                List<Integer> component = new ArrayList<>();
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                visited[i] = true;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    component.add(node);
                    for (int neighbor : graph.get(node)) {
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }

                // Step 3: Check if component is complete
                int nodes = component.size();
                int edgeCount = 0;
                for (int node : component) {
                    edgeCount += graph.get(node).size();
                }
                edgeCount /= 2; // because edges are bidirectional and counted twice

                if (edgeCount == nodes * (nodes - 1) / 2) {
                    count++;
                }
            }
        }

        return count;
    }
}
