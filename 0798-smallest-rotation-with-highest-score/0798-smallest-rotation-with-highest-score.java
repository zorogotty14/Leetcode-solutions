class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] change = new int[n + 1]; // Change array to track score impact
        
        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;  // Start of range where nums[i] contributes
            int high = (i - nums[i] + n + 1) % n; // End of range where nums[i] stops contributing
            
            // Increment score impact at low
            change[low]++;
            // Decrement score impact after high
            if (high != 0) change[high]--;
        }
        
        // Calculate cumulative scores for all rotations
        int maxScore = 0, bestK = 0, currentScore = 0;
        for (int k = 0; k < n; k++) {
            currentScore += change[k];
            if (currentScore > maxScore) {
                maxScore = currentScore;
                bestK = k;
            }
        }
        
        return bestK;
    }
}
