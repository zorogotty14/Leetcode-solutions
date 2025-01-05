class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] shift = new int[n + 1]; // Extra space to handle range ends

        // Step 1: Populate the shift array
        for (int[] sh : shifts) {
            int start = sh[0], end = sh[1], direction = sh[2];
            shift[start] += (direction == 1) ? 1 : -1;
            shift[end + 1] -= (direction == 1) ? 1 : -1;
        }

        // Step 2: Compute cumulative shifts using prefix sum
        int cumulativeShift = 0;
        for (int i = 0; i < n; i++) {
            cumulativeShift += shift[i];
            shift[i] = cumulativeShift; // Update the shift array to hold cumulative shifts
        }

        // Step 3: Apply shifts to the string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int originalCharIndex = s.charAt(i) - 'a';
            int shiftedIndex = (originalCharIndex + shift[i]) % 26; // Modulo 26 for wrapping
            if (shiftedIndex < 0) {
                shiftedIndex += 26; // Handle negative shifts
            }
            result.append((char) ('a' + shiftedIndex));
        }

        return result.toString();
    }
}
