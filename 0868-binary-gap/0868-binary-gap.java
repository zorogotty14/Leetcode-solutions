class Solution {
    public int binaryGap(int n) {
        String binary = Integer.toBinaryString(n); // Convert n to its binary representation
        int lastPosition = -1; // To store the position of the previous 1
        int maxDistance = 0;   // To store the maximum distance

        // Iterate through the binary representation
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                // If we find a 1, calculate the distance from the last 1
                if (lastPosition != -1) {
                    maxDistance = Math.max(maxDistance, i - lastPosition);
                }
                lastPosition = i; // Update the last position of 1
            }
        }

        return maxDistance; // Return the maximum distance
    }
}
