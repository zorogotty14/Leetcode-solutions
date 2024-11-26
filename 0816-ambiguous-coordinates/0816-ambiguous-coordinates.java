import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> ambiguousCoordinates(String s) {
        List<String> result = new ArrayList<>();

        // Remove the outer parentheses
        String digits = s.substring(1, s.length() - 1);

        // Split the string into two parts in all possible ways
        for (int i = 1; i < digits.length(); i++) {
            String left = digits.substring(0, i);
            String right = digits.substring(i);

            // Get all valid representations for both parts
            List<String> leftOptions = getValidNumbers(left);
            List<String> rightOptions = getValidNumbers(right);

            // Combine valid left and right parts to form coordinates
            for (String l : leftOptions) {
                for (String r : rightOptions) {
                    result.add("(" + l + ", " + r + ")");
                }
            }
        }

        return result;
    }

    private List<String> getValidNumbers(String s) {
        List<String> result = new ArrayList<>();
        int n = s.length();

        // Case 1: The entire string as an integer (no decimal point)
        if (isValidInteger(s)) {
            result.add(s);
        }

        // Case 2: Insert a decimal point in all valid positions
        for (int i = 1; i < n; i++) {
            String left = s.substring(0, i);
            String right = s.substring(i);

            if (isValidInteger(left) && isValidDecimalPart(right)) {
                result.add(left + "." + right);
            }
        }

        return result;
    }

    private boolean isValidInteger(String s) {
        // A valid integer has no leading zeros unless it is "0"
        return !(s.startsWith("0") && s.length() > 1);
    }

    private boolean isValidDecimalPart(String s) {
        // A valid decimal part has no trailing zeros
        return !s.endsWith("0");
    }
}
