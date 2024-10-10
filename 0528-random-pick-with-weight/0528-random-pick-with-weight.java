import java.util.Random;

class Solution {
    private int[] prefixSums;
    private int totalSum;
    private Random rand;

    public Solution(int[] w) {
        // Initialize the random number generator
        this.rand = new Random();
        
        // Build the prefix sum array
        prefixSums = new int[w.length];
        prefixSums[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + w[i];
        }
        
        // The total sum of the weights
        totalSum = prefixSums[prefixSums.length - 1];
    }
    
    public int pickIndex() {
        // Generate a random number between 1 and totalSum (inclusive)
        int target = rand.nextInt(totalSum) + 1;
        
        // Binary search to find the target index in prefixSums
        int low = 0;
        int high = prefixSums.length - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (prefixSums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}
