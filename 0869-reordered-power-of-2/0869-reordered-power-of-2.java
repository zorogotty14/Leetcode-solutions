import java.util.*;

class Solution {
    public boolean reorderedPowerOf2(int n) {
        // Compute the digit count for n
        int[] targetCount = digitCount(n);
        
        // Check digit count against all powers of two up to 10^9
        for (int i = 0; i < 31; i++) { // 2^30 is the largest power of 2 <= 10^9
            int[] powerOf2Count = digitCount(1 << i); // Compute digit count of 2^i
            if (Arrays.equals(targetCount, powerOf2Count)) {
                return true; // If digit counts match, n can be reordered to form 2^i
            }
        }
        
        return false; // No match found
    }
    
    // Helper function to compute digit counts
    private int[] digitCount(int num) {
        int[] count = new int[10]; // Array to store counts of digits 0-9
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }
        return count;
    }
}
