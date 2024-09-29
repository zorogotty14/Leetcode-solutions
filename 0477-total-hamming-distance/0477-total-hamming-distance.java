class Solution {
    public int totalHammingDistance(int[] nums) {
        int total = 0;
        int n = nums.length;
        
        // Iterate over each bit position from 0 to 31
        for (int i = 0; i < 32; i++) {
            int countOnes = 0;
            
            // Count how many numbers have the i-th bit set to 1
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    countOnes++;
                }
            }
            
            // countZeros = n - countOnes
            int countZeros = n - countOnes;
            
            // Add to the total Hamming distance for this bit position
            total += countOnes * countZeros;
        }
        
        return total;
    }
}
