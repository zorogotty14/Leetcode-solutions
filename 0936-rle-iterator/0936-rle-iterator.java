class RLEIterator {
    private int[] encoding; // Array to store the RLE encoding
    private int index;      // Current index in the encoding array

    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        this.index = 0;       // Start at the beginning of the encoding array
    }

    public int next(int n) {
        while (index < encoding.length) {
            // If the current frequency is greater than or equal to n
            if (encoding[index] >= n) {
                encoding[index] -= n; // Decrease the frequency
                return encoding[index + 1]; // Return the current value
            } else {
                // Exhaust the current frequency and move to the next pair
                n -= encoding[index];
                encoding[index] = 0; // Set the current frequency to 0
                index += 2;          // Move to the next pair
            }
        }

        // If we run out of elements, return -1
        return -1;
    }
}
