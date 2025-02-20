class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        StringBuilder result = new StringBuilder();
        
        // Construct a binary string using diagonalization
        for (int i = 0; i < n; i++) {
            // Flip the i-th character (if '0' -> '1', if '1' -> '0')
            char flippedBit = nums[i].charAt(i) == '0' ? '1' : '0';
            result.append(flippedBit);
        }
        
        return result.toString();
    }
}
