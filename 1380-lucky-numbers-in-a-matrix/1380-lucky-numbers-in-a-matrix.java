class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Step 1: Find the minimum element in each row
        int[] minInRow = new int[m];
        for (int i = 0; i < m; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
            }
            minInRow[i] = min;
        }
        
        // Step 2: Find the maximum element in each column
        int[] maxInCol = new int[n];
        for (int j = 0; j < n; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
            maxInCol[j] = max;
        }
        
        // Step 3: Find common elements between minInRow and maxInCol
        List<Integer> luckyNumbers = new ArrayList<>();
        Set<Integer> maxInColSet = new HashSet<>();
        for (int max : maxInCol) {
            maxInColSet.add(max);
        }
        
        for (int min : minInRow) {
            if (maxInColSet.contains(min)) {
                luckyNumbers.add(min);
            }
        }
        
        return luckyNumbers;
    }
}