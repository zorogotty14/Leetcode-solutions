import java.util.HashSet;

class Solution {
    public int countPalindromicSubsequence(String s) {
        // Set to store unique palindromic subsequences
        HashSet<String> uniquePalindromes = new HashSet<>();
        
        // Iterate through all lowercase English letters
        for (char ch = 'a'; ch <= 'z'; ch++) {
            // Find the first and last occurrence of the current character
            int first = s.indexOf(ch);
            int last = s.lastIndexOf(ch);
            
            // If there's enough space between first and last occurrence
            if (first != -1 && last != -1 && first < last) {
                // Use a set to collect unique characters between first and last
                HashSet<Character> seen = new HashSet<>();
                for (int i = first + 1; i < last; i++) {
                    seen.add(s.charAt(i));
                }
                
                // Add all palindromic subsequences of form "aXa" to the result set
                for (char mid : seen) {
                    uniquePalindromes.add("" + ch + mid + ch);
                }
            }
        }
        
        // Return the number of unique palindromic subsequences
        return uniquePalindromes.size();
    }
}
