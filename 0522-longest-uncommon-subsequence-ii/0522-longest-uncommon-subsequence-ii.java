class Solution {
    // Helper function to check if a is a subsequence of b
    private boolean isSubsequence(String a, String b) {
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == a.length();
    }

    public int findLUSlength(String[] strs) {
        // Sort strings by length in descending order
        Arrays.sort(strs, (s1, s2) -> s2.length() - s1.length());

        // Try each string
        for (int i = 0; i < strs.length; i++) {
            boolean isUncommon = true;
            // Check if the current string is a subsequence of any other string
            for (int j = 0; j < strs.length; j++) {
                if (i != j && isSubsequence(strs[i], strs[j])) {
                    isUncommon = false;
                    break;
                }
            }
            // If the string is not a subsequence of any other string, return its length
            if (isUncommon) {
                return strs[i].length();
            }
        }
        
        // If no uncommon subsequence found, return -1
        return -1;
    }
}
