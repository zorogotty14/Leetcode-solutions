class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flattenedBoard = new int[n * n + 1];
        boolean leftToRight = true;
        int idx = 1;
        
        // Flatten the board
        for (int i = n - 1; i >= 0; i--) {
            if (leftToRight) {
                for (int j = 0; j < n; j++) {
                    flattenedBoard[idx++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    flattenedBoard[idx++] = board[i][j];
                }
            }
            leftToRight = !leftToRight;
        }
        
        // BFS to find the shortest path
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                if (curr == n * n) {
                    return moves;
                }
                for (int next = curr + 1; next <= Math.min(curr + 6, n * n); next++) {
                    int dest = flattenedBoard[next] == -1 ? next : flattenedBoard[next];
                    if (!visited[dest]) {
                        visited[dest] = true;
                        queue.offer(dest);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}