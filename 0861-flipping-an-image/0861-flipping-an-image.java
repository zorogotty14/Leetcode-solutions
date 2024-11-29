class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length; // Size of the matrix

        for (int i = 0; i < n; i++) {
            int start = 0, end = n - 1;

            // Flip the row while inverting the elements
            while (start <= end) {
                // Swap and invert the elements
                int temp = image[i][start] ^ 1;
                image[i][start] = image[i][end] ^ 1;
                image[i][end] = temp;

                start++;
                end--;
            }
        }

        return image;
    }
}
