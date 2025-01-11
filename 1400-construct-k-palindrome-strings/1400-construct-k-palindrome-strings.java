class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of s, it's impossible to form k palindromes
        if (k > s.length()) {
            return false;
        }

        // Count the frequency of each character in the string
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count the number of characters with odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) {
                oddCount++;
            }
        }

        // The number of palindromes that can be formed is limited by the oddCount
        // We need at least oddCount palindromes, so oddCount <= k
        return oddCount <= k;
    }
}
