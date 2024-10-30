class Solution {
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        int violations = 0; // Track the number of violations

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                violations++;

                // If more than one violation, return false immediately
                if (violations > 1) {
                    return false;
                }

                // Modify nums[i] or nums[i + 1] to maintain non-decreasing order
                if (i == 0 || nums[i - 1] <= nums[i + 1]) {
                    // Lower nums[i] to nums[i + 1]
                    nums[i] = nums[i + 1];
                } else {
                    // Raise nums[i + 1] to nums[i]
                    nums[i + 1] = nums[i];
                }
            }
        }

        return true;
    }
}
