class Solution {
    public int[] singleNumber(int[] nums) {
        // Step 1: XOR all elements to find x ^ y
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }

        // Step 2: Find a bit that is different between x and y (any set bit in xor)
        int diffBit = xor & (-xor);

        // Step 3: Partition the numbers into two groups and XOR to find the unique numbers
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & diffBit) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }

        return result;
    }
}
