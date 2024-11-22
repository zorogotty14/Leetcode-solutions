import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        
        // Start DFS from node 0
        dfs(graph, 0, currentPath, result);
        return result;
    }
    
    private void dfs(int[][] graph, int currentNode, List<Integer> currentPath, List<List<Integer>> result) {
        currentPath.add(currentNode);
        
        // If we reach the last node, add the current path to the result
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(currentPath));
        } else {
            // Traverse all neighbors of the current node
            for (int neighbor : graph[currentNode]) {
                dfs(graph, neighbor, currentPath, result);
            }
        }
        
        // Backtrack
        currentPath.remove(currentPath.size() - 1);
    }
}
