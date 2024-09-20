class Solution {
    public String shortestPalindrome(String s) {
        String rev_s = new StringBuilder(s).reverse().toString();
        String l = s + "#" + rev_s;
        
        int[] p = new int[l.length()];
        
        // KMP table to find the longest prefix which is also suffix
        for (int i = 1; i < l.length(); i++) {
            int j = p[i - 1];
            while (j > 0 && l.charAt(i) != l.charAt(j)) {
                j = p[j - 1];
            }
            if (l.charAt(i) == l.charAt(j)) {
                j++;
            }
            p[i] = j;
        }
        
        // Length of the longest palindromic prefix
        int longest_palindromic_prefix_length = p[l.length() - 1];
        
        // Suffix that needs to be added in front to make the string a palindrome
        String suffix_to_add = rev_s.substring(0, s.length() - longest_palindromic_prefix_length);
        
        return suffix_to_add + s;
    }
}