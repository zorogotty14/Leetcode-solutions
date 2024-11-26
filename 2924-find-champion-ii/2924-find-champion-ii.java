class Solution {
    public int findChampion(int n, int[][] edges) {
        // Step 1: Initialize indegree array
        int[] indegree = new int[n];

        // Step 2: Populate indegree array using edges
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            indegree[to]++;
        }

        // Step 3: Identify the potential champion
        int champion = -1;  // Store the potential champion
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                if (champion == -1) {
                    champion = i;  // Found a potential champion
                } else {
                    return -1;  // More than one node with indegree 0
                }
            }
        }

        // Step 4: Return the result
        return champion;  // Return the champion or -1 if none exists
    }
}
