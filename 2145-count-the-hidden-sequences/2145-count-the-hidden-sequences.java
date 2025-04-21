class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        // Initialize variables to track the minimum and maximum possible values
        long min = 0;
        long max = 0;
        long currentSum = 0;
        
        // Iterate through the differences array
        for (int diff : differences) {
            // Calculate the running sum (potential sequence values)
            currentSum += diff;
            
            // Track the minimum and maximum values the sequence could take
            min = Math.min(min, currentSum);
            max = Math.max(max, currentSum);
        }
        
        // Calculate the offset range we can shift the entire sequence by
        // (upper - max) is the maximum we can shift up
        // (lower - min) is the minimum we can shift up
        long offset = (upper - max) - (lower - min) + 1;
        
        // If offset <= 0, there are no valid sequences
        return offset <= 0 ? 0 : (int)offset;
    }
}