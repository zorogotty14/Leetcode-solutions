import java.util.*;

class Solution {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        // Perform topological sort on row and column conditions
        List<Integer> rowOrder = topoSort(k, rowConditions);
        List<Integer> colOrder = topoSort(k, colConditions);

        // If either order is empty, return an empty matrix
        if (rowOrder.isEmpty() || colOrder.isEmpty()) {
            return new int[0][0];
        }

        // Map each number to its position in the topological order
        int[] rowPos = new int[k + 1];
        int[] colPos = new int[k + 1];
        for (int i = 0; i < k; i++) {
            rowPos[rowOrder.get(i)] = i;
            colPos[colOrder.get(i)] = i;
        }

        // Build the k x k matrix
        int[][] matrix = new int[k][k];
        for (int num = 1; num <= k; num++) {
            matrix[rowPos[num]][colPos[num]] = num;
        }

        return matrix;
    }

    // Topological sorting helper method
    private List<Integer> topoSort(int k, int[][] conditions) {
        int[] inDegree = new int[k + 1];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // Build the graph and compute in-degrees
        for (int[] condition : conditions) {
            int u = condition[0];
            int v = condition[1];
            graph.computeIfAbsent(u, x -> new ArrayList<>()).add(v);
            inDegree[v]++;
        }

        // Topological sort using Kahn's algorithm
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> order = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            order.add(node);

            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        // If not all nodes are processed, there is a cycle
        if (order.size() != k) {
            return new ArrayList<>();
        }

        return order;
    }
}
