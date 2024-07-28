class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {    
        
        // Create the graph using adjacency list
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        // Store the minimum and second minimum arrival times for each vertex
        long[][] dist = new long[n + 1][2];
        for (long[] d : dist) {
            Arrays.fill(d, Long.MAX_VALUE);
        }
        
        // Use a queue for BFS
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(1, 0L));
        dist[1][0] = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // Calculate waiting time if the current traffic signal is red
            long wait = 0;
            if ((current.time / change) % 2 == 1) {
                wait = change - (current.time % change);
            }
            
            // Calculate the new time to reach adjacent nodes
            long newTime = current.time + wait + time;
            
            for (int neighbor : graph[current.vertex]) {
                // Check for the first time arrival
                if (dist[neighbor][0] > newTime) {
                    dist[neighbor][1] = dist[neighbor][0];
                    dist[neighbor][0] = newTime;
                    queue.offer(new Node(neighbor, newTime));
                }
                // Check for the second time arrival
                else if (newTime > dist[neighbor][0] && newTime < dist[neighbor][1]) {
                    dist[neighbor][1] = newTime;
                    queue.offer(new Node(neighbor, newTime));
                    // If the neighbor is the destination vertex, return the second minimum time
                    if (neighbor == n) {
                        return (int)newTime;
                    }
                }
            }
        }
        
        return -1; // Should never reach here if the graph is always connected
    }
    
    // Node class to store the current vertex and the time to reach it
    private static class Node {
        int vertex;
        long time;
        
        Node(int vertex, long time) {
            this.vertex = vertex;
            this.time = time;
        }
    }
    
}