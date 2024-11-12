class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        // If the starting pixel is already the target color, no change is needed
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private void dfs(int[][] image, int r, int c, int originalColor, int newColor) {
        // Boundary check and ensure we only fill pixels of the original color
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        // Change the color of the current pixel
        image[r][c] = newColor;

        // Perform DFS for the four adjacent pixels (up, down, left, right)
        dfs(image, r - 1, c, originalColor, newColor); // Up
        dfs(image, r + 1, c, originalColor, newColor); // Down
        dfs(image, r, c - 1, originalColor, newColor); // Left
        dfs(image, r, c + 1, originalColor, newColor); // Right
    }
}
