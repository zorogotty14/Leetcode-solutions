import java.util.*;

class Solution {
    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        int n = amount.length;
        List<Integer>[] graph = new ArrayList[n];

        // Step 1: Build the adjacency list representation of the tree
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // Step 2: Find Bob's path to node 0 and store arrival times
        int[] bobTime = new int[n];
        Arrays.fill(bobTime, Integer.MAX_VALUE);
        findBobPath(graph, bob, -1, 0, bobTime);

        // Step 3: Find Alice's maximum profit path
        return dfsAlice(graph, 0, -1, 0, 0, bobTime, amount);
    }

    // DFS to find Bob's path to node 0 and store the time he reaches each node
    private boolean findBobPath(List<Integer>[] graph, int node, int parent, int time, int[] bobTime) {
        bobTime[node] = time;
        if (node == 0) return true; // Reached root
        
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                if (findBobPath(graph, neighbor, node, time + 1, bobTime)) {
                    return true; // Keep track of the valid path
                }
            }
        }
        
        bobTime[node] = Integer.MAX_VALUE; // If not in path, reset
        return false;
    }

    // DFS for Alice to maximize profit while considering Bob’s path
    private int dfsAlice(List<Integer>[] graph, int node, int parent, int time, int profit, int[] bobTime, int[] amount) {
        // Step 1: Compute Alice's income at this node
        if (time < bobTime[node]) {
            profit += amount[node]; // Alice reaches first
        } else if (time == bobTime[node]) {
            profit += amount[node] / 2; // Alice and Bob share the amount
        } // If Bob arrives earlier, Alice gets nothing

        // Step 2: Traverse children to find maximum profit path
        int maxProfit = Integer.MIN_VALUE;
        boolean isLeaf = true;
        
        for (int neighbor : graph[node]) {
            if (neighbor != parent) {
                isLeaf = false;
                maxProfit = Math.max(maxProfit, dfsAlice(graph, neighbor, node, time + 1, profit, bobTime, amount));
            }
        }

        return isLeaf ? profit : maxProfit; // If leaf node, return profit
    }
}
