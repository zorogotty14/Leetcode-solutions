import java.util.*;

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        
        // Calculate distances from node1 to all reachable nodes
        int[] dist1 = getDistances(edges, node1);
        
        // Calculate distances from node2 to all reachable nodes
        int[] dist2 = getDistances(edges, node2);
        
        int result = -1;
        int minMaxDist = Integer.MAX_VALUE;
        
        // Check each node to see if it's reachable from both starting nodes
        for (int i = 0; i < n; i++) {
            // Node i must be reachable from both node1 and node2
            if (dist1[i] != -1 && dist2[i] != -1) {
                int maxDist = Math.max(dist1[i], dist2[i]);
                
                // Update result if we found a better node (smaller max distance)
                // or same max distance but smaller index
                if (maxDist < minMaxDist) {
                    minMaxDist = maxDist;
                    result = i;
                }
            }
        }
        
        return result;
    }
    
    private int[] getDistances(int[] edges, int start) {
        int n = edges.length;
        int[] distances = new int[n];
        Arrays.fill(distances, -1); // -1 means unreachable
        
        int current = start;
        int dist = 0;
        
        // Follow the path until we reach a node we've already visited or a dead end
        while (current != -1 && distances[current] == -1) {
            distances[current] = dist;
            current = edges[current];
            dist++;
        }
        
        return distances;
    }
}