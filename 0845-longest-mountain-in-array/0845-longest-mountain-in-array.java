class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int longest = 0;

        for (int i = 1; i < n - 1; ) {
            // Check if arr[i] is a peak
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                int left = i - 1;
                int right = i + 1;

                // Expand to the left
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left--;
                }

                // Expand to the right
                while (right < n - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // Calculate the mountain length
                int mountainLength = right - left + 1;
                longest = Math.max(longest, mountainLength);

                // Move `i` to the end of the current mountain
                i = right + 1;
            } else {
                // Move to the next potential peak
                i++;
            }
        }

        return longest;
    }
}
