class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0, oddCount = 0, result = 0;
        int[] prefix = new int[nums.length + 1];
        prefix[0] = 1;

        for (int num : nums) {
            if (num % 2 == 1) {
                oddCount++;
            }
            if (oddCount >= k) {
                result += prefix[oddCount - k];
            }
            prefix[oddCount]++;
        }

        return result;
    }
}