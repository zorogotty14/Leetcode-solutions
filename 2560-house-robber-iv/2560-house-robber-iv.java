class Solution {
    public int minCapability(int[] nums, int k) {
        int left = 1, right = (int) 1e9; // Capability range from min(nums) to max(nums)
        int result = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canRobAtLeastK(nums, k, mid)) {
                result = mid; // Found a valid capability, try to minimize it
                right = mid - 1;
            } else {
                left = mid + 1; // Need a higher capability
            }
        }
        return result;
    }

    private boolean canRobAtLeastK(int[] nums, int k, int maxCap) {
        int count = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (nums[i] <= maxCap) { // Can rob this house
                count++;
                i++; // Skip adjacent house
            }
            if (count >= k) return true; // If we rob at least k houses
        }
        return count >= k;
    }
}
