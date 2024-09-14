import java.util.HashMap;

class Solution {
    public int longestPalindrome(String s) {
        // Step 1: Count the frequency of each character
        HashMap<Character, Integer> charCount = new HashMap<>();
        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean oddFound = false;

        // Step 2: Calculate the length of the longest palindrome
        for (int count : charCount.values()) {
            if (count % 2 == 0) {
                // If the count is even, add it to the length
                length += count;
            } else {
                // If the count is odd, add (count - 1) to the length
                length += count - 1;
                oddFound = true;
            }
        }

        // Step 3: If there's any odd count, add 1 for the center character
        if (oddFound) {
            length += 1;
        }

        return length;
    }
}
