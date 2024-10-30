class Solution {
    public int[][] imageSmoother(int[][] img) {
        int m = img.length;    // Number of rows
        int n = img[0].length; // Number of columns

        int[][] result = new int[m][n]; // Store the result

        // Directions array for 8 neighbors + current cell (9 total positions)
        int[] directions = {-1, 0, 1};

        // Iterate through each cell in the original image
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                // Check all neighbors (and the current cell itself)
                for (int di : directions) {
                    for (int dj : directions) {
                        int ni = i + di; // Neighbor row
                        int nj = j + dj; // Neighbor column

                        // If the neighbor is within the image boundaries
                        if (ni >= 0 && ni < m && nj >= 0 && nj < n) {
                            sum += img[ni][nj]; // Add the value to sum
                            count++;            // Increment the count
                        }
                    }
                }

                // Store the floored average in the result matrix
                result[i][j] = sum / count;
            }
        }

        return result;
    }
}
