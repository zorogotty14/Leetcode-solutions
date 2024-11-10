class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;

        // Traverse the array until the second-to-last bit
        while (i < n - 1) {
            if (bits[i] == 1) {
                // If it's a '1', move by two steps (two-bit character)
                i += 2;
            } else {
                // If it's a '0', move by one step (one-bit character)
                i++;
            }
        }

        // If we end at the last bit (index n-1), it's a one-bit character
        return i == n - 1;
    }
}
