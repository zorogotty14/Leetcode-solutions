class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] flat = new int[size];
        
        // Flatten the grid
        int index = 0;
        for (int[] row : grid) {
            for (int num : row) {
                flat[index++] = num;
            }
        }

        // Check if it's possible to make the grid uni-value
        int mod = flat[0] % x;
        for (int num : flat) {
            if (num % x != mod) {
                return -1;
            }
        }

        // Sort and find median
        Arrays.sort(flat);
        int median = flat[size / 2];
        int operations = 0;

        for (int num : flat) {
            operations += Math.abs(num - median) / x;
        }

        return operations;
    }
}
