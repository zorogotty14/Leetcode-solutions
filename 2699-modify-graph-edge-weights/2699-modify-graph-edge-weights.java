import java.util.*;

class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        int[][] result = new int[edges.length][3];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1], w = edges[i][2];
            graph[u].add(new int[]{v, w, i});
            graph[v].add(new int[]{u, w, i});
            result[i] = new int[]{u, v, w};
        }
        
        int[] dist = dijkstra(graph, n, edges, source, -1);
        if (dist[destination] != Integer.MAX_VALUE && dist[destination] < target) {
            for (int[] edge : edges) {
                if (edge[2] == -1) edge[2] = 1;
            }
            dist = dijkstra(graph, n, edges, source, destination);
            if (dist[destination] < target) {
                int increment = target - dist[destination];
                for (int[] edge : edges) {
                    if (edge[2] == 1 && dist[edge[0]] < dist[edge[1]]) {
                        edge[2] += increment;
                        break;
                    }
                }
            }
        } else if (dist[destination] == Integer.MAX_VALUE || dist[destination] > target) {
            return new int[0][0];
        }

        for (int[] edge : edges) {
            if (edge[2] == -1) edge[2] = 1;
        }
        dist = dijkstra(graph, n, edges, source, destination);
        if (dist[destination] != target) {
            return new int[0][0];
        }

        return edges;
    }
    
    private int[] dijkstra(List<int[]>[] graph, int n, int[][] edges, int source, int destination) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{source, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            if (d > dist[u]) continue;
            for (int[] edge : graph[u]) {
                int v = edge[0], w = edges[edge[2]][2];
                if (w == -1) w = 1; // For initial consideration of -1 edges.
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
