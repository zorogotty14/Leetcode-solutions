class Solution {
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n]; // Position map – where is each element in nums2?
        
        for (int i = 0; i < n; i++) {
            pos[nums2[i]] = i;
        }
        
        int[] mapped = new int[n];
        for (int i = 0; i < n; i++) {
            mapped[i] = pos[nums1[i]];
        }
        
        // First pass: count elements to the left
        long[] left = new long[n];
        int[] bit = new int[n + 2]; // extra room for classic off-by-one safety
        for (int i = 0; i < n; i++) {
            left[i] = query(bit, mapped[i]);
            update(bit, mapped[i] + 1, 1); // 1-indexed for BIT
        }
        
        // Second pass: count elements to the right
        long[] right = new long[n];
        bit = new int[n + 2];
        for (int i = n - 1; i >= 0; i--) {
            right[i] = query(bit, n) - query(bit, mapped[i] + 1);
            update(bit, mapped[i] + 1, 1);
        }
        
        // Calculate result
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += left[i] * right[i]; // Middle element magic
        }
        
        return res;
    }
    
    // Binary Indexed Tree operations
    void update(int[] bit, int i, int val) {
        while (i < bit.length) {
            bit[i] += val;
            i += i & -i; // Add least significant bit
        }
    }
    
    int query(int[] bit, int i) {
        int res = 0;
        while (i > 0) {
            res += bit[i];
            i -= i & -i; // Remove least significant bit
        }
        return res;
    }
}