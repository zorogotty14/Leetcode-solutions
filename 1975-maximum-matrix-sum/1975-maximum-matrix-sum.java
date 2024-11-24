class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long totalSum = 0;
        int negativeCount = 0;
        int minAbs = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);
                if (value < 0) {
                    negativeCount++;
                }
                minAbs = Math.min(minAbs, Math.abs(value));
            }
        }

        // If the number of negatives is even, return the total sum
        if (negativeCount % 2 == 0) {
            return totalSum;
        }

        // If the number of negatives is odd, subtract twice the smallest absolute value
        return totalSum - 2 * minAbs;
    }
}
