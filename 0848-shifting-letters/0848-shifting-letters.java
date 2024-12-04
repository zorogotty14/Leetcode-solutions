class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = shifts.length;
        // Compute the cumulative shifts starting from the end
        for (int i = n - 2; i >= 0; i--) {
            shifts[i] = (shifts[i] + shifts[i + 1]) % 26; // Use modulo 26 to avoid unnecessary large shifts
        }

        // Create a StringBuilder to build the result
        StringBuilder result = new StringBuilder(s);

        // Apply the shifts
        for (int i = 0; i < n; i++) {
            char shiftedChar = (char) ((s.charAt(i) - 'a' + shifts[i]) % 26 + 'a');
            result.setCharAt(i, shiftedChar);
        }

        return result.toString();
    }
}
