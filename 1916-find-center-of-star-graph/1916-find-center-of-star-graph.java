class Solution {
    public int findCenter(int[][] edges) {
        // Get the nodes of the first edge
        int u1 = edges[0][0];
        int v1 = edges[0][1];
        
        // Get the nodes of the second edge
        int u2 = edges[1][0];
        int v2 = edges[1][1];
        
        // The center node is the one common node in the first two edges
        if (u1 == u2 || u1 == v2) {
            return u1;
        } else {
            return v1;
        }
    }
}