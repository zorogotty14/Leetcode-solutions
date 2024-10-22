import java.util.*;

class Solution {
    public boolean isValid(String code) {
        Stack<String> stack = new Stack<>();
        int i = 0;
        int n = code.length();

        while (i < n) {
            // Check if this is a start tag or end tag
            if (i > 0 && code.startsWith("<![CDATA[", i)) {
                // Find the end of CDATA content
                int j = i + 9; // Start after "<![CDATA["
                int end = code.indexOf("]]>", j);
                if (end < 0) return false; // CDATA not closed properly
                i = end + 3; // Move index past "]]>"
            } else if (code.startsWith("</", i)) {
                // Find end of end tag
                int end = code.indexOf('>', i);
                if (end < 0) return false; // Tag not closed properly

                String tagName = code.substring(i + 2, end);
                if (stack.isEmpty() || !stack.pop().equals(tagName)) {
                    return false; // Mismatched end tag or no matching start tag
                }
                i = end + 1; // Move index past the end tag
                // If the stack is empty and we are not at the end of the code, it's invalid
                if (stack.isEmpty() && i < n) return false;
            } else if (code.startsWith("<", i)) {
                // Find end of start tag
                int end = code.indexOf('>', i);
                if (end < 0) return false; // Tag not closed properly

                String tagName = code.substring(i + 1, end);
                if (!isValidTagName(tagName)) return false; // Invalid tag name

                stack.push(tagName); // Push the tag name onto the stack
                i = end + 1; // Move index past the start tag
            } else {
                // Normal content; skip over it
                i++;
            }
        }

        return stack.isEmpty(); // All tags must be closed properly
    }

    private boolean isValidTagName(String tagName) {
        // A valid tag name consists only of uppercase letters and has length [1,9]
        if (tagName.length() < 1 || tagName.length() > 9) return false;
        for (char c : tagName.toCharArray()) {
            if (!Character.isUpperCase(c)) return false;
        }
        return true;
    }
}
