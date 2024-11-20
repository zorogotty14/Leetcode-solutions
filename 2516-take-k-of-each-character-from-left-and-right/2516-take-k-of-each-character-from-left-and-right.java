class Solution {
    public int takeCharacters(String s, int k) {
        // Count total occurrences of 'a', 'b', and 'c' in the string
        int[] totalCount = new int[3];
        for (char ch : s.toCharArray()) {
            totalCount[ch - 'a']++;
        }

        // If there are not enough characters of any type, return -1
        if (totalCount[0] < k || totalCount[1] < k || totalCount[2] < k) {
            return -1;
        }

        // Use sliding window to find the longest substring that, if removed, would leave
        // at least k of each character on both ends
        int n = s.length();
        int[] count = new int[3]; // count for the current window
        int maxWindow = 0; // length of the maximum valid window
        int left = 0;

        for (int right = 0; right < n; right++) {
            // Add the current character to the window count
            count[s.charAt(right) - 'a']++;

            // Shrink the window from the left if we have too many of any character
            while (count[0] > totalCount[0] - k || count[1] > totalCount[1] - k || count[2] > totalCount[2] - k) {
                count[s.charAt(left) - 'a']--;
                left++;
            }

            // Calculate the length of the current valid window
            maxWindow = Math.max(maxWindow, right - left + 1);
        }

        // Minimum number of characters to take is the complement of the maximum window length
        return n - maxWindow;
    }
}
