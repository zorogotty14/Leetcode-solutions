import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() <= 1) return s;

        List<String> specialSubstrings = new ArrayList<>();
        int count = 0, start = 0;

        // Split the string into special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }
            // When we find a balanced substring (count == 0), process it
            if (count == 0) {
                // Recursively call makeLargestSpecial on the inner substring
                String inner = makeLargestSpecial(s.substring(start + 1, i));
                // Wrap it with '1' and '0' to maintain the special substring format
                specialSubstrings.add("1" + inner + "0");
                // Update start for the next substring
                start = i + 1;
            }
        }

        // Sort the substrings in descending order to get the lexicographically largest result
        Collections.sort(specialSubstrings, Collections.reverseOrder());

        // Concatenate the substrings to form the result
        StringBuilder result = new StringBuilder();
        for (String str : specialSubstrings) {
            result.append(str);
        }

        return result.toString();
    }
}
