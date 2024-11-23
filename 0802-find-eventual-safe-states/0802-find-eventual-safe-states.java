import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] outdegree = new int[n];
        
        // Initialize the reverse graph
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        
        // Build the reverse graph and calculate outdegree
        for (int i = 0; i < n; i++) {
            for (int j : graph[i]) {
                reverseGraph.get(j).add(i); // Reverse the edge
            }
            outdegree[i] = graph[i].length; // Count outgoing edges
        }
        
        // Queue to process terminal nodes
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all terminal nodes (outdegree == 0) to the queue
        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                queue.add(i);
            }
        }
        
        // List to store safe nodes
        List<Integer> safeNodes = new ArrayList<>();
        
        // Process nodes in the queue
        while (!queue.isEmpty()) {
            int node = queue.poll();
            safeNodes.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                outdegree[neighbor]--;
                if (outdegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        
        // Sort safe nodes in ascending order
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
