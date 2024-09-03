import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> wordDict = new HashMap<>();
        
        // Populate the dictionary with reversed words and their indices
        for (int i = 0; i < words.length; i++) {
            wordDict.put(new StringBuilder(words[i]).reverse().toString(), i);
        }
        
        
        
        // Iterate over each word to find palindrome pairs
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            
            for (int j = 0; j <= word.length(); j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);
                
                // Case 1: Check if prefix is a palindrome and if suffix's reverse exists in the dictionary
                if (isPalindrome(prefix) && wordDict.containsKey(suffix) && wordDict.get(suffix) != i) {
                    result.add(List.of(wordDict.get(suffix), i));
                }
                
                // Case 2: Check if suffix is a palindrome and if prefix's reverse exists in the dictionary
                if (j != word.length() && isPalindrome(suffix) && wordDict.containsKey(prefix) && wordDict.get(prefix) != i) {
                    result.add(List.of(i, wordDict.get(prefix)));
                }
            }
        }
        
        return result;
    }
    // Function to check if a string is a palindrome
        public boolean isPalindrome(String s) {
            int left = 0, right = s.length() - 1;
            while (left < right) {
                if (s.charAt(left++) != s.charAt(right--)) {
                    return false;
                }
            }
            return true;
        }
}
