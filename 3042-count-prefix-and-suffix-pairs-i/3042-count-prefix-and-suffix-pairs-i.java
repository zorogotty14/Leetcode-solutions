class Solution {
    public int countPrefixSuffixPairs(String[] words) {
        int count = 0;

        // Iterate over all pairs (i, j) where i < j
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if (isPrefixAndSuffix(words[i], words[j])) {
                    count++;
                }
            }
        }

        return count;
    }

    // Helper function to check if str1 is both a prefix and suffix of str2
    private boolean isPrefixAndSuffix(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();

        // str1 cannot be a prefix and suffix if it's longer than str2
        if (len1 > len2) {
            return false;
        }

        // Check prefix
        boolean isPrefix = str2.startsWith(str1);

        // Check suffix
        boolean isSuffix = str2.endsWith(str1);

        return isPrefix && isSuffix;
    }
}
