import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int[] result = new int[m * n];
        int index = 0;
        
        // Iterate over diagonals
        for (int d = 0; d < m + n - 1; d++) {
            // Temporary list to store elements of the current diagonal
            List<Integer> diagonal = new ArrayList<>();
            
            // Determine the start point for this diagonal
            int r = d < n ? 0 : d - n + 1;
            int c = d < n ? d : n - 1;
            
            // Collect elements in this diagonal
            while (r < m && c >= 0) {
                diagonal.add(mat[r][c]);
                r++;
                c--;
            }
            
            // Reverse diagonal if needed (for even-indexed diagonals)
            if (d % 2 == 0) {
                for (int i = diagonal.size() - 1; i >= 0; i--) {
                    result[index++] = diagonal.get(i);
                }
            } else {
                for (int i = 0; i < diagonal.size(); i++) {
                    result[index++] = diagonal.get(i);
                }
            }
        }
        
        return result;
    }
}
