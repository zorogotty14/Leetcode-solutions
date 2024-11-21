class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // Calculate player's distance to the target
        int playerDistance = manhattanDistance(0, 0, target[0], target[1]);

        // Check each ghost's distance to the target
        for (int[] ghost : ghosts) {
            int ghostDistance = manhattanDistance(ghost[0], ghost[1], target[0], target[1]);
            // If any ghost can reach the target as quickly as or faster than the player
            if (ghostDistance <= playerDistance) {
                return false;
            }
        }

        // Player can escape
        return true;
    }

    // Helper function to calculate Manhattan Distance
    private int manhattanDistance(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }
}
