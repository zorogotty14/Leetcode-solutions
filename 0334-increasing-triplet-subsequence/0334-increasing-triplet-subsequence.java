class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num <= first) {
                first = num;  // Update first to be the smallest so far
            } else if (num <= second) {
                second = num; // Update second to be the second smallest
            } else {
                // If we find a number greater than both first and second,
                // then we have found an increasing triplet
                return true;
            }
        }
        
        return false; // No increasing triplet found
    }
}
