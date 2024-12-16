import java.util.Arrays;

class Solution {
    public int sumSubseqWidths(int[] nums) {
        final int MOD = 1_000_000_007;
        int n = nums.length;

        // Sort the array
        Arrays.sort(nums);

        // Precompute powers of 2 modulo MOD
        long[] powerOfTwo = new long[n];
        powerOfTwo[0] = 1;
        for (int i = 1; i < n; i++) {
            powerOfTwo[i] = (powerOfTwo[i - 1] * 2) % MOD;
        }

        long result = 0;

        // Calculate contributions
        for (int i = 0; i < n; i++) {
            long maxContribution = powerOfTwo[i];
            long minContribution = powerOfTwo[n - i - 1];
            result = (result + (nums[i] * (maxContribution - minContribution)) % MOD) % MOD;
        }

        return (int) result;
    }
}
