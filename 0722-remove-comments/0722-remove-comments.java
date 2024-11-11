import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>();
        StringBuilder currentLine = new StringBuilder();
        boolean inBlockComment = false;

        for (String line : source) {
            int i = 0;
            // Process each character in the line
            while (i < line.length()) {
                if (!inBlockComment) {
                    // Look for the start of a block comment
                    if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '*') {
                        inBlockComment = true;
                        i += 2; // Move past the "/*"
                    }
                    // Look for a line comment
                    else if (i + 1 < line.length() && line.charAt(i) == '/' && line.charAt(i + 1) == '/') {
                        break; // Ignore the rest of the line
                    }
                    // Regular character outside of comments
                    else {
                        currentLine.append(line.charAt(i));
                        i++;
                    }
                } else {
                    // Look for the end of a block comment
                    if (i + 1 < line.length() && line.charAt(i) == '*' && line.charAt(i + 1) == '/') {
                        inBlockComment = false;
                        i += 2; // Move past the "*/"
                    } else {
                        i++;
                    }
                }
            }

            // If not in a block comment and the current line is non-empty, add it to the result
            if (!inBlockComment && currentLine.length() > 0) {
                result.add(currentLine.toString());
                currentLine.setLength(0); // Clear the current line buffer
            }
        }

        return result;
    }
}
