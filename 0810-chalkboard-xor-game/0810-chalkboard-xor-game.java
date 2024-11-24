class Solution {
    public boolean xorGame(int[] nums) {
        int xor = 0;

        // Compute the XOR of all elements
        for (int num : nums) {
            xor ^= num;
        }

        // Check winning conditions
        return xor == 0 || nums.length % 2 == 0;
    }
}
