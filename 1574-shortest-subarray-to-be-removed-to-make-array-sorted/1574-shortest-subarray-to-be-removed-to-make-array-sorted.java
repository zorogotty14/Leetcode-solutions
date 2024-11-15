class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int left = 0;

        // Find the longest non-decreasing prefix
        while (left < n - 1 && arr[left] <= arr[left + 1]) {
            left++;
        }
        if (left == n - 1) {
            return 0; // Already non-decreasing
        }

        int right = n - 1;
        // Find the longest non-decreasing suffix
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }

        // Minimum subarray length to remove
        int minLength = Math.min(n - left - 1, right);

        // Try to merge the prefix and suffix
        int i = 0, j = right;
        while (i <= left && j < n) {
            if (arr[i] <= arr[j]) {
                minLength = Math.min(minLength, j - i - 1);
                i++;
            } else {
                j++;
            }
        }

        return minLength;
    }
}
