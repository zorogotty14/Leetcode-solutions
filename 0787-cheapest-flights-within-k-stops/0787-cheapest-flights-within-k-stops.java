import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Build adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] flight : flights) {
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        // Queue for BFS: {current node, accumulated cost}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        // Min cost array to track minimum cost to each node at each level
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        minCost[src] = 0;

        int stops = 0;
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            // Temporary array to hold updates for the current level
            int[] tempCost = minCost.clone();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int node = curr[0];
                int costSoFar = curr[1];

                for (int[] neighbor : adj.get(node)) {
                    int nextNode = neighbor[0];
                    int price = neighbor[1];
                    int newCost = costSoFar + price;

                    // Only update if the new cost is cheaper
                    if (newCost < tempCost[nextNode]) {
                        tempCost[nextNode] = newCost;
                        q.offer(new int[]{nextNode, newCost});
                    }
                }
            }

            // Update the minCost array after exploring all nodes at this level
            minCost = tempCost;
            stops++;
        }

        return minCost[dst] == Integer.MAX_VALUE ? -1 : minCost[dst];
    }
}
