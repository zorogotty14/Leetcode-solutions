class Solution {
    public int[] constructArray(int n, int k) {
        int[] result = new int[n];
        int low = 1, high = n;
        
        // Alternate between low and high to generate k distinct differences
        int i = 0;
        while (k > 0) {
            if (k % 2 == 1) {
                result[i++] = low++;
            } else {
                result[i++] = high--;
            }
            k--;
        }
        
        // Fill the remaining numbers in increasing order
        if (low <= high) {
            for (int j = low; j <= high; j++) {
                result[i++] = j;
            }
        }
        
        return result;
    }
}


