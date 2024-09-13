class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        // Step 1: Create a prefix XOR array
        int n = arr.length;
        int[] prefixXor = new int[n];
        prefixXor[0] = arr[0];
        
        // Compute the prefix XOR for the array
        for (int i = 1; i < n; i++) {
            prefixXor[i] = prefixXor[i - 1] ^ arr[i];
        }
        
        // Step 2: Process each query and compute the XOR from left to right
        int m = queries.length;
        int[] result = new int[m];
        
        for (int i = 0; i < m; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            
            // If left == 0, result is simply prefixXor[right]
            if (left == 0) {
                result[i] = prefixXor[right];
            } else {
                // Otherwise, it's prefixXor[right] ^ prefixXor[left - 1]
                result[i] = prefixXor[right] ^ prefixXor[left - 1];
            }
        }
        
        return result;
    }
}
