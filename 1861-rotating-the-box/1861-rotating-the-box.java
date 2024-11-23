class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;  // number of rows
        int n = box[0].length;  // number of columns
        
        // Simulate gravity for each row
        for (int i = 0; i < m; i++) {
            int empty = n - 1; // Position to move stones
            for (int j = n - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    // Move the stone to the `empty` position
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                } else if (box[i][j] == '*') {
                    // Reset the `empty` pointer at the obstacle
                    empty = j - 1;
                }
            }
        }
        
        // Rotate the box 90 degrees clockwise
        char[][] rotated = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = box[i][j];
            }
        }
        
        return rotated;
    }
}
