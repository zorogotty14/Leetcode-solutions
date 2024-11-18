import java.util.*;

class Solution {
    public int slidingPuzzle(int[][] board) {
        // Target solved state as a string for easy comparison
        String target = "123450";
        
        // Initial board state as a string
        StringBuilder startBuilder = new StringBuilder();
        for (int[] row : board) {
            for (int num : row) {
                startBuilder.append(num);
            }
        }
        String start = startBuilder.toString();

        // If the board is already in the target state
        if (start.equals(target)) {
            return 0;
        }

        // Possible moves for the 0 position based on the 2x3 board
        int[][] neighbors = {
            {1, 3},       // 0th index can move to 1st or 3rd index
            {0, 2, 4},    // 1st index can move to 0th, 2nd, or 4th index
            {1, 5},       // 2nd index can move to 1st or 5th index
            {0, 4},       // 3rd index can move to 0th or 4th index
            {1, 3, 5},    // 4th index can move to 1st, 3rd, or 5th index
            {2, 4}        // 5th index can move to 2nd or 4th index
        };

        // BFS
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);

        int moves = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }

                int zeroIndex = current.indexOf('0');
                for (int neighbor : neighbors[zeroIndex]) {
                    String next = swap(current, zeroIndex, neighbor);
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }

        return -1; // If no solution is found
    }

    // Helper function to swap characters in the string
    private String swap(String s, int i, int j) {
        char[] charArray = s.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return new String(charArray);
    }
}
