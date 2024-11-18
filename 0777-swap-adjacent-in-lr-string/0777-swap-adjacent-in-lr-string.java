class Solution {
    public boolean canTransform(String start, String result) {
        // Check if lengths are different
        if (start.length() != result.length()) {
            return false;
        }

        // Remove 'X' characters and check if 'L' and 'R' characters match in order
        String sFiltered = start.replace("X", "");
        String rFiltered = result.replace("X", "");
        if (!sFiltered.equals(rFiltered)) {
            return false;
        }

        // Traverse and check the valid movement of 'L' and 'R'
        int n = start.length();
        int i = 0, j = 0;

        while (i < n && j < n) {
            // Skip 'X' in start
            while (i < n && start.charAt(i) == 'X') {
                i++;
            }
            // Skip 'X' in result
            while (j < n && result.charAt(j) == 'X') {
                j++;
            }

            // If either pointer exceeds the length, break the loop
            if (i == n || j == n) {
                break;
            }

            // Check if characters do not match
            if (start.charAt(i) != result.charAt(j)) {
                return false;
            }

            // Check the movement rules for 'L' and 'R'
            if (start.charAt(i) == 'L' && i < j) {
                // 'L' can only move to the left (i >= j should hold)
                return false;
            }
            if (start.charAt(i) == 'R' && i > j) {
                // 'R' can only move to the right (i <= j should hold)
                return false;
            }

            // Move both pointers
            i++;
            j++;
        }

        return true;
    }
}
