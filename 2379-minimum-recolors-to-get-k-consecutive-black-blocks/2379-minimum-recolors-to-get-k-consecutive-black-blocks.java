class Solution {
    public int minimumRecolors(String blocks, int k) {
        int minOperations = Integer.MAX_VALUE;
        int currentWhiteCount = 0;

        // Initialize the first window of size k
        for (int i = 0; i < k; i++) {
            if (blocks.charAt(i) == 'W') {
                currentWhiteCount++;
            }
        }
        minOperations = currentWhiteCount;

        // Slide the window across the string
        for (int i = k; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                currentWhiteCount++;
            }
            if (blocks.charAt(i - k) == 'W') {
                currentWhiteCount--;
            }
            minOperations = Math.min(minOperations, currentWhiteCount);
        }

        return minOperations;
    }
}