import java.util.*;

class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1;
        int m = edges2.length + 1;
        
        // Build adjacency lists
        List<List<Integer>> adj1 = buildAdjList(edges1, n);
        List<List<Integer>> adj2 = buildAdjList(edges2, m);
        
        // For tree1: calculate reachable nodes within distance k for each node
        int[] reachableTree1 = new int[n];
        for (int i = 0; i < n; i++) {
            reachableTree1[i] = countReachableNodes(adj1, i, k);
        }
        
        // For tree2: calculate reachable nodes within distance k-1 for each node
        // (k-1 because we use 1 edge to connect between trees)
        int[] reachableTree2 = new int[m];
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                reachableTree2[i] = countReachableNodes(adj2, i, k - 1);
            }
        }
        
        // Find the maximum reachable nodes in tree2
        int maxTree2 = 0;
        for (int count : reachableTree2) {
            maxTree2 = Math.max(maxTree2, count);
        }
        
        // For each node in tree1, the answer is:
        // nodes reachable in tree1 + max nodes reachable in tree2 through optimal connection
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = reachableTree1[i] + maxTree2;
        }
        
        return answer;
    }
    
    private List<List<Integer>> buildAdjList(int[][] edges, int n) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        return adj;
    }
    
    private int countReachableNodes(List<List<Integer>> adj, int start, int maxDist) {
        if (maxDist < 0) return 0;
        
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        int[] distance = new int[adj.size()];
        
        queue.offer(start);
        visited[start] = true;
        distance[start] = 0;
        
        int count = 1; // Count the starting node itself
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            if (distance[node] < maxDist) {
                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        distance[neighbor] = distance[node] + 1;
                        queue.offer(neighbor);
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}