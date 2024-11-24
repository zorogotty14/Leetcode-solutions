class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lineCount = 1;  // Start with 1 line
        int currentLineWidth = 0;

        for (char c : s.toCharArray()) {
            int width = widths[c - 'a'];  // Get the width of the character
            if (currentLineWidth + width > 100) {
                // Start a new line
                lineCount++;
                currentLineWidth = width;  // Start the new line with this character
            } else {
                currentLineWidth += width;  // Add width to the current line
            }
        }

        return new int[] {lineCount, currentLineWidth};
    }
}
