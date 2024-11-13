import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Create an adjacency list for the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            graph.computeIfAbsent(time[0], x -> new ArrayList<>()).add(new int[]{time[1], time[2]});
        }

        // Use a priority queue to implement Dijkstra's algorithm
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0}); // {node, current time}

        // Distance map to store the shortest time to reach each node
        Map<Integer, Integer> dist = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int time = current[1];

            // If we've already visited this node, skip it
            if (dist.containsKey(node)) continue;
            dist.put(node, time);

            // Traverse all neighbors
            if (graph.containsKey(node)) {
                for (int[] edge : graph.get(node)) {
                    int nextNode = edge[0];
                    int travelTime = edge[1];
                    if (!dist.containsKey(nextNode)) {
                        pq.offer(new int[]{nextNode, time + travelTime});
                    }
                }
            }
        }

        // Check if all nodes were reached
        if (dist.size() != n) return -1;

        // Find the maximum time taken to reach any node
        int result = 0;
        for (int time : dist.values()) {
            result = Math.max(result, time);
        }
        return result;
    }
}
