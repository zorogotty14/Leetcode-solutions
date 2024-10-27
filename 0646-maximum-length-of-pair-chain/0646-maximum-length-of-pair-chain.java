import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        // Sort pairs by their right endpoint (ascending order)
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int currentEnd = Integer.MIN_VALUE;
        int chainLength = 0;

        // Iterate through the sorted pairs
        for (int[] pair : pairs) {
            if (pair[0] > currentEnd) {
                // If the current pair can extend the chain
                chainLength++;
                currentEnd = pair[1]; // Update the end of the current chain
            }
        }

        return chainLength;
    }
}
