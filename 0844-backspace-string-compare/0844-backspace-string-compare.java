class Solution {
    public boolean backspaceCompare(String s, String t) {
        return processString(s).equals(processString(t));
    }

    private String processString(String str) {
        // Use a stack to simulate the backspace operation
        StringBuilder result = new StringBuilder();

        for (char c : str.toCharArray()) {
            if (c == '#') {
                // Simulate backspace by removing the last character if present
                if (result.length() > 0) {
                    result.deleteCharAt(result.length() - 1);
                }
            } else {
                // Add character to the result
                result.append(c);
            }
        }

        return result.toString();
    }
}
