class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int j = 0; // Pointer for str2
        
        // Iterate through str1
        for (int i = 0; i < m && j < n; i++) {
            // Check if the current character in str1 can match str2[j]
            // either directly or by incrementing cyclically
            if (str1.charAt(i) == str2.charAt(j) || 
                ((str1.charAt(i) - 'a' + 1) % 26 + 'a') == str2.charAt(j)) {
                j++; // Move the pointer for str2
            }
        }
        
        // If we have traversed all characters of str2, it is a subsequence
        return j == n;
    }
}

