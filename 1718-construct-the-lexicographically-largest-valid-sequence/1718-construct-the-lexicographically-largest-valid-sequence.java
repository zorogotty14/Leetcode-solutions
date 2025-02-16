class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];  // The sequence length is 2n - 1
        boolean[] used = new boolean[n + 1];  // To track whether a number has been placed
        
        backtrack(result, used, 0, n);
        return result;
    }
    
    private boolean backtrack(int[] result, boolean[] used, int index, int n) {
        if (index == result.length) {
            return true;  // Successfully placed all numbers
        }
        
        if (result[index] != 0) {
            return backtrack(result, used, index + 1, n);  // Skip already filled positions
        }
        
        for (int num = n; num >= 1; num--) {  // Try placing the largest number first
            if (!used[num]) {
                if (num == 1 || (index + num < result.length && result[index + num] == 0)) {
                    result[index] = num;
                    if (num > 1) result[index + num] = num;  // Place the second occurrence for num > 1
                    used[num] = true;
                    
                    if (backtrack(result, used, index + 1, n)) {
                        return true;  // Found a valid sequence
                    }
                    
                    // Backtrack
                    result[index] = 0;
                    if (num > 1) result[index + num] = 0;
                    used[num] = false;
                }
            }
        }
        
        return false;
    }
}
