class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            // When k == 0, replace all elements with 0
            return result; // By default, all elements are 0
        }

        // Iterate over each element in the array
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            if (k > 0) {
                // Calculate sum of the next k elements (wrapping around)
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Use modulo to wrap around
                }
            } else {
                // Calculate sum of the previous |k| elements (wrapping around)
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Use modulo to wrap around
                }
            }
            result[i] = sum;
        }

        return result;
    }
}
