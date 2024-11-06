class Solution {
    public int countBinarySubstrings(String s) {
        int prevGroupSize = 0; // Size of the previous contiguous group
        int currGroupSize = 1; // Size of the current contiguous group
        int count = 0;

        // Traverse the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                // Continue counting the size of the current group
                currGroupSize++;
            } else {
                // New group starts, add minimum of prev and current group sizes to count
                count += Math.min(prevGroupSize, currGroupSize);
                // Move to the new group
                prevGroupSize = currGroupSize;
                currGroupSize = 1;
            }
        }

        // Add the last group comparison
        count += Math.min(prevGroupSize, currGroupSize);

        return count;
    }
}
