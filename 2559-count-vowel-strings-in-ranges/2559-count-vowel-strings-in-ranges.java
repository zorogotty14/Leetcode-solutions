class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] prefix = new int[n + 1]; // prefix[0] = 0

        // Build the prefix sum array
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (isVowelString(words[i]) ? 1 : 0);
        }

        // Answer the queries
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int li = queries[i][0];
            int ri = queries[i][1];
            ans[i] = prefix[ri + 1] - prefix[li];
        }

        return ans;
    }

    // Helper function to check if a word starts and ends with a vowel
    private boolean isVowelString(String word) {
        if (word == null || word.length() == 0) return false;
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return isVowel(first) && isVowel(last);
    }

    // Helper function to check if a character is a vowel
    private boolean isVowel(char c) {
        // Considering lowercase vowels as per the constraints
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
