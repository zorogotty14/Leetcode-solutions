import java.util.*;

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        // Tree representation as an adjacency list
        List<List<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        // Arrays to store results and auxiliary data
        int[] answer = new int[n];
        int[] count = new int[n];

        // First DFS to calculate count and initial distance sum
        dfs(0, -1, tree, count, answer);

        // Second DFS to adjust distances for all nodes
        dfs2(0, -1, tree, count, answer, n);

        return answer;
    }

    private void dfs(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer) {
        count[node] = 1; // Include the current node itself
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue; // Avoid revisiting the parent
            dfs(neighbor, node, tree, count, answer);
            count[node] += count[neighbor];
            answer[node] += answer[neighbor] + count[neighbor];
        }
    }

    private void dfs2(int node, int parent, List<List<Integer>> tree, int[] count, int[] answer, int n) {
        for (int neighbor : tree.get(node)) {
            if (neighbor == parent) continue; // Avoid revisiting the parent
            // Transition formula to calculate answer for the child
            answer[neighbor] = answer[node] + (n - count[neighbor]) - count[neighbor];
            dfs2(neighbor, node, tree, count, answer, n);
        }
    }
}
