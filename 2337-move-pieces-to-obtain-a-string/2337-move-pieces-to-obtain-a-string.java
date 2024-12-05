class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int i = 0, j = 0;

        while (i < n || j < n) {
            // Find the next non-blank in start
            while (i < n && start.charAt(i) == '_') i++;
            // Find the next non-blank in target
            while (j < n && target.charAt(j) == '_') j++;

            // If both pointers reach the end, the strings are compatible
            if (i == n && j == n) return true;

            // If only one pointer reaches the end, strings are incompatible
            if (i == n || j == n) return false;

            // If the characters at the current positions do not match
            if (start.charAt(i) != target.charAt(j)) return false;

            // Validate movement rules
            if (start.charAt(i) == 'L' && i < j) return false; // 'L' can only move left
            if (start.charAt(i) == 'R' && i > j) return false; // 'R' can only move right

            // Move to the next character
            i++;
            j++;
        }

        return true;
    }
}
