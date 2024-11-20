import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] chars, int index, List<String> result) {
        // If we've reached the end of the string, add the current permutation to the result
        if (index == chars.length) {
            result.add(new String(chars));
            return;
        }

        // Backtrack on the current character
        if (Character.isLetter(chars[index])) {
            // Change case and backtrack
            chars[index] = Character.toLowerCase(chars[index]);
            backtrack(chars, index + 1, result);

            chars[index] = Character.toUpperCase(chars[index]);
            backtrack(chars, index + 1, result);
        } else {
            // If it's not a letter, just continue
            backtrack(chars, index + 1, result);
        }
    }
}
