class NumArray {

    private int[] prefixSums;

    public NumArray(int[] nums) {
        int n = nums.length;
        prefixSums = new int[n];
        prefixSums[0] = nums[0];

        // Compute the prefix sums
        for (int i = 1; i < n; i++) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefixSums[right];
        } else {
            return prefixSums[right] - prefixSums[left - 1];
        }
    }
}

