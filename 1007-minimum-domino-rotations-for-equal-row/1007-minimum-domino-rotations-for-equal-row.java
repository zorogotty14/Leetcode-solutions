class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        // We need to check if we can make all tops equal to tops[0]
        // or all tops equal to bottoms[0]
        // or all bottoms equal to tops[0]
        // or all bottoms equal to bottoms[0]
        int n = tops.length;
        
        // Try to make all tops equal to tops[0]
        int rotationsTopToTop0 = checkRotations(tops[0], tops, bottoms, n);
        
        // Try to make all tops equal to bottoms[0]
        int rotationsTopToBottom0 = checkRotations(bottoms[0], tops, bottoms, n);
        
        // Try to make all bottoms equal to tops[0]
        int rotationsBottomToTop0 = checkRotations(tops[0], bottoms, tops, n);
        
        // Try to make all bottoms equal to bottoms[0]
        int rotationsBottomToBottom0 = checkRotations(bottoms[0], bottoms, tops, n);
        
        // Find the minimum rotations needed
        int minRotations = Math.min(
            Math.min(rotationsTopToTop0, rotationsTopToBottom0),
            Math.min(rotationsBottomToTop0, rotationsBottomToBottom0)
        );
        
        // Return -1 if no valid solution, otherwise return the minimum rotations
        return minRotations == Integer.MAX_VALUE ? -1 : minRotations;
    }
    
    // Helper function to check how many rotations needed to make all elements in
    // the target array equal to the value
    private int checkRotations(int value, int[] primary, int[] secondary, int n) {
        int rotations = 0;
        
        for (int i = 0; i < n; i++) {
            // If primary already has the value, no rotation needed
            if (primary[i] == value) {
                continue;
            }
            // If secondary has the value, we can rotate
            else if (secondary[i] == value) {
                rotations++;
            }
            // If neither has the value, we can't make all elements equal to value
            else {
                return Integer.MAX_VALUE; // Return a large value to indicate impossibility
            }
        }
        
        return rotations;
    }
}