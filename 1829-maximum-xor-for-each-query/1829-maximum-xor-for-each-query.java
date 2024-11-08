class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int maxNum = (1 << maximumBit) - 1;  // Maximum value for k < 2^maximumBit
        int xorSum = 0;

        // Compute the initial XOR of the array
        for (int num : nums) {
            xorSum ^= num;
        }

        // Iterate and find the value of k for each query
        for (int i = 0; i < n; i++) {
            answer[i] = xorSum ^ maxNum;  // Maximize k by XORing with maxNum
            xorSum ^= nums[n - 1 - i];    // Remove the last element in the current array
        }

        return answer;
    }
}
