class Solution {
    public int findLUSlength(String a, String b) {
        // If the strings are equal, there is no uncommon subsequence
        if (a.equals(b)) {
            return -1;
        }
        
        // If the strings are different, the longest uncommon subsequence is the longer string
        // because a string itself cannot be a subsequence of the other if they are different.
        return Math.max(a.length(), b.length());
    }
}
