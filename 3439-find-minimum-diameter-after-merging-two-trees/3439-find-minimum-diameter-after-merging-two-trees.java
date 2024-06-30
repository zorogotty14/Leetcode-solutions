class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        List<Integer>[] adj1 = buildAdjacencyList(edges1);
        List<Integer>[] adj2 = buildAdjacencyList(edges2);

        // Find the diameters of the two trees
        int d1 = findDiameter(adj1);
        int d2 = findDiameter(adj2);

        // The minimum possible diameter of the resulting tree
        return Math.max(Math.max(d1, d2), (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
    }
    private int findDiameter(List<Integer>[] adj) {
        int n = adj.length;
        int[] dist = new int[n];

        // First BFS to find the farthest node from an arbitrary starting point (node 0)
        int farthestNode = bfs(0, adj, dist);

        // Second BFS from the farthest node found in the first BFS
        Arrays.fill(dist, 0);
        farthestNode = bfs(farthestNode, adj, dist);

        // The maximum distance found in the second BFS is the diameter of the tree
        return Arrays.stream(dist).max().getAsInt();
    }

    // BFS to find the farthest node and compute distances
    private int bfs(int start, List<Integer>[] adj, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.length];
        queue.offer(start);
        visited[start] = true;

        int farthestNode = start;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    dist[neighbor] = dist[node] + 1;
                    queue.offer(neighbor);
                    if (dist[neighbor] > dist[farthestNode]) {
                        farthestNode = neighbor;
                    }
                }
            }
        }

        return farthestNode;
    }

    // Helper method to build the adjacency list from the edge list
    private List<Integer>[] buildAdjacencyList(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        return adj;
    }
}