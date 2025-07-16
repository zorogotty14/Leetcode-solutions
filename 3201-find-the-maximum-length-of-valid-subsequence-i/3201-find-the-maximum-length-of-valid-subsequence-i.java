class Solution {
    public int maximumLength(int[] nums) {
    return Math.max(
            Math.max(longestAllEvenOrOdd(nums, true), longestAllEvenOrOdd(nums, false)),
            Math.max(longestAlternating(nums, true), longestAlternating(nums, false))
        );
    }

    private int longestAllEvenOrOdd(int[] nums, boolean even) {
        int count = 0;
        for (int num : nums) {
            if ((num % 2 == 0) == even) {
                count++;
            }
        }
        return count;
    }

    private int longestAlternating(int[] nums, boolean startEven) {
        int count = 0;
        boolean expectedEven = startEven;
        for (int num : nums) {
            if ((num % 2 == 0) == expectedEven) {
                count++;
                expectedEven = !expectedEven;
            }
        }
        return count;
    }
}