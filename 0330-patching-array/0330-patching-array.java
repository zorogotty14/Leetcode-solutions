class Solution {
    public int minPatches(int[] nums, int n) {
        int patches = 0;
        long miss = 1;
        int i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                // If nums[i] is within the current coverage range, extend the coverage
                miss += nums[i];
                i++;
            } else {
                // Patch the array with `miss`
                miss += miss;
                patches++;
            }
        }

        return patches;
    }
}
