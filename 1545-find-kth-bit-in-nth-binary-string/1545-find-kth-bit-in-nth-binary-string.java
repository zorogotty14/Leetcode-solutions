class Solution {
    public char findKthBit(int n, int k) {
        // Base case: If we are at the first string S1
        if (n == 1) {
            return '0';
        }
        
        // Determine the midpoint of the current string S_n
        int mid = (1 << (n - 1));  // Equivalent to 2^(n-1)

        if (k == mid) {
            // If k is exactly at the midpoint, it's always '1'
            return '1';
        } else if (k < mid) {
            // If k is in the left part, it corresponds directly to S_{n-1}
            return findKthBit(n - 1, k);
        } else {
            // If k is in the right part, map k to the left part of S_{n-1}
            // The mirrored position in S_{n-1} is calculated as:
            int mirroredK = mid - (k - mid);
            // The right part is the inverted reverse, so we invert the result
            return invert(findKthBit(n - 1, mirroredK));
        }
    }

    private char invert(char bit) {
        return bit == '0' ? '1' : '0';
    }
}
