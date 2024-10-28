class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        // Iterate over each possible center of a palindrome
        for (int i = 0; i < n; i++) {
            // Expand around the center for odd-length palindromes
            count += expandAroundCenter(s, i, i);
            // Expand around the center for even-length palindromes
            count += expandAroundCenter(s, i, i + 1);
        }

        return count;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;

        // Expand as long as the substring is a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;  // Found a palindromic substring
            left--;   // Expand left
            right++;  // Expand right
        }

        return count;
    }
}
