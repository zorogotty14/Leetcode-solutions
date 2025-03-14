class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, m = queries.length;
        int left = 0, right = m, result = -1;

        // Binary search on number of queries processed
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canZeroArray(nums.clone(), queries, mid)) {
                result = mid;
                right = mid - 1; // Try to find a smaller valid k
            } else {
                left = mid + 1; // Increase k
            }
        }
        return result;
    }

    private boolean canZeroArray(int[] nums, int[][] queries, int k) {
        int n = nums.length;
        int[] diff = new int[n + 2]; // Difference array for efficient range updates

        // Apply first k queries using difference array
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            diff[l] -= val;
            diff[r + 1] += val;
        }

        // Compute the actual decrements and apply to nums
        int currentDecrement = 0;
        for (int i = 0; i < n; i++) {
            currentDecrement += diff[i]; // Apply accumulated decrement
            nums[i] += currentDecrement; // Apply to nums
            if (nums[i] > 0) return false; // If any element is >0 after k queries, k is too small
        }
        return true; // nums is zeroed
    }
}
