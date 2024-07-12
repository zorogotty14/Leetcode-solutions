class Solution {
    public int maximumGain(String s, int x, int y) {
        if (x < y) {
            // Swap x and y and replace "ab" with "ba" and vice versa in the problem to always prioritize the higher score removal
            return calculateScore(s, y, x, 'b', 'a');
        } else {
            return calculateScore(s, x, y, 'a', 'b');
        }
    }

    private int calculateScore(String s, int firstScore, int secondScore, char firstChar, char secondChar) {
        int totalScore = 0;
        StringBuilder stack = new StringBuilder();

        // Step 1: Remove the highest score substring
        for (char c : s.toCharArray()) {
            if (stack.length() > 0 && c == secondChar && stack.charAt(stack.length() - 1) == firstChar) {
                stack.deleteCharAt(stack.length() - 1);
                totalScore += firstScore;
            } else {
                stack.append(c);
            }
        }

        // Step 2: Remove the second highest score substring
        String remainingString = stack.toString();
        stack.setLength(0);
        for (char c : remainingString.toCharArray()) {
            if (stack.length() > 0 && c == firstChar && stack.charAt(stack.length() - 1) == secondChar) {
                stack.deleteCharAt(stack.length() - 1);
                totalScore += secondScore;
            } else {
                stack.append(c);
            }
        }

        return totalScore;
    }
}