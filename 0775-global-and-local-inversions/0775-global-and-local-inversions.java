class Solution {
    public boolean isIdealPermutation(int[] nums) {
        int n = nums.length;
        // Check if every number is at most 1 place away from its sorted position
        for (int i = 0; i < n; i++) {
            // If the number is more than 1 position away from its correct sorted position
            if (Math.abs(nums[i] - i) > 1) {
                return false;
            }
        }
        return true;
    }
}
