import java.util.*;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n]; // Track visited rooms
        Queue<Integer> queue = new LinkedList<>();
        
        // Start from room 0
        queue.add(0);
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            int currentRoom = queue.poll();
            // Visit all rooms that the current room has keys for
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    queue.add(key);
                }
            }
        }
        
        // Check if all rooms are visited
        for (boolean isVisited : visited) {
            if (!isVisited) return false;
        }
        
        return true;
    }
}
