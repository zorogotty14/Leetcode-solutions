class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int xor1 = 0, xor2 = 0;

        // Compute XOR of all elements in nums1 and nums2
        for (int num : nums1) {
            xor1 ^= num;
        }
        for (int num : nums2) {
            xor2 ^= num;
        }

        int result = 0;

        // Add contributions from nums1 if nums2's length is odd
        if (nums2.length % 2 != 0) {
            result ^= xor1;
        }

        // Add contributions from nums2 if nums1's length is odd
        if (nums1.length % 2 != 0) {
            result ^= xor2;
        }

        return result;
    }
}
