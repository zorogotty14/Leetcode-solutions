class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int best = values[0] + 0;     // best so far for (values[i] + i)
        int result = Integer.MIN_VALUE;
        
        // Start from j = 1 because we need i < j
        for (int j = 1; j < values.length; j++) {
            // Candidate score with the best i found so far
            int candidate = best + values[j] - j;
            if (candidate > result) {
                result = candidate;
            }
            
            // Update best if current (values[j] + j) is better
            int current = values[j] + j;
            if (current > best) {
                best = current;
            }
        }
        
        return result;
    }
}
