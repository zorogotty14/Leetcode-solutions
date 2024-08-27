import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target, int pos, long currentValue, long lastValue, String path) {
        // Base case: if we have reached the end of the string
        if (pos == num.length()) {
            if (currentValue == target) {
                result.add(path);
            }
            return;
        }

        // Try all possible partitions of the remaining string
        for (int i = pos; i < num.length(); i++) {
            // Extract the current portion of the string
            String part = num.substring(pos, i + 1);
            long currentNum = Long.parseLong(part);

            // Skip numbers with leading zeros
            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            if (pos == 0) {
                // Starting point, add the number without any operator
                backtrack(result, num, target, i + 1, currentNum, currentNum, part);
            } else {
                // Try adding '+'
                backtrack(result, num, target, i + 1, currentValue + currentNum, currentNum, path + "+" + part);
                // Try adding '-'
                backtrack(result, num, target, i + 1, currentValue - currentNum, -currentNum, path + "-" + part);
                // Try adding '*'
                backtrack(result, num, target, i + 1, currentValue - lastValue + lastValue * currentNum, lastValue * currentNum, path + "*" + part);
            }
        }
    }
}
