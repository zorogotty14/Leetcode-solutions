class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmasks = new int[n];
        int[] lengths = new int[n];

        // Precompute bitmasks and lengths
        for (int i = 0; i < n; i++) {
            int bitmask = 0;
            for (char c : words[i].toCharArray()) {
                bitmask |= 1 << (c - 'a');
            }
            bitmasks[i] = bitmask;
            lengths[i] = words[i].length();
        }

        int maxProduct = 0;

        // Compare each pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((bitmasks[i] & bitmasks[j]) == 0) { // No common letters
                    int product = lengths[i] * lengths[j];
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }

        return maxProduct;
    }
}
