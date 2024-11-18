class Solution {
    public int kthGrammar(int n, int k) {
        // Base case: if we are at the first row, the only symbol is 0
        if (n == 1) {
            return 0;
        }
        
        // Find the length of the (n-1)th row, which is (2^(n-1)) / 2
        int mid = (1 << (n - 1)) / 2; // Equivalent to 2^(n-1) / 2

        if (k <= mid) {
            // If k is in the first half, it mirrors the same position in (n-1)th row
            return kthGrammar(n - 1, k);
        } else {
            // If k is in the second half, it is the complement of the (k - mid)th position in (n-1)th row
            return 1 - kthGrammar(n - 1, k - mid);
        }
    }
}
