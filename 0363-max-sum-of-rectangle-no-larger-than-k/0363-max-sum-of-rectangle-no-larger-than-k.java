import java.util.TreeSet;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int maxSum = Integer.MIN_VALUE;

        // Iterate over all pairs of rows
        for (int r1 = 0; r1 < m; r1++) {
            // This array will store the sum of elements between row r1 and r2 for each column
            int[] colSums = new int[n];

            for (int r2 = r1; r2 < m; r2++) {
                // Update colSums by adding the elements of row r2
                for (int c = 0; c < n; c++) {
                    colSums[c] += matrix[r2][c];
                }

                // Now apply Kadane's algorithm with binary search to find the max subarray sum <= k
                maxSum = Math.max(maxSum, maxSubArrayNoLargerThanK(colSums, k));
            }
        }

        return maxSum;
    }

    // Helper function to find the max subarray sum in a 1D array that is <= k
    private int maxSubArrayNoLargerThanK(int[] arr, int k) {
        TreeSet<Integer> cumSet = new TreeSet<>();
        cumSet.add(0);
        int cumSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int sum : arr) {
            cumSum += sum;

            // We want cumSum - x <= k -> x >= cumSum - k
            Integer x = cumSet.ceiling(cumSum - k);
            if (x != null) {
                maxSum = Math.max(maxSum, cumSum - x);
            }

            // Add the current cumulative sum to the set
            cumSet.add(cumSum);
        }

        return maxSum;
    }
}
