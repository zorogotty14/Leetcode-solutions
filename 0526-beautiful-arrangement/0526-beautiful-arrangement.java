class Solution {
    private int count = 0;

    public int countArrangement(int n) {
        boolean[] visited = new boolean[n + 1]; // To track the numbers that have been used
        backtrack(n, 1, visited);
        return count;
    }

    // Backtracking function to construct the arrangement
    private void backtrack(int n, int index, boolean[] visited) {
        // If we have placed numbers in all positions, we found a valid arrangement
        if (index > n) {
            count++;
            return;
        }

        // Try placing each number from 1 to n at the current index
        for (int num = 1; num <= n; num++) {
            // If num is not used yet and it satisfies the beautiful arrangement condition
            if (!visited[num] && (num % index == 0 || index % num == 0)) {
                visited[num] = true; // Mark num as used
                backtrack(n, index + 1, visited); // Recurse to the next index
                visited[num] = false; // Backtrack (unmark num)
            }
        }
    }
}
