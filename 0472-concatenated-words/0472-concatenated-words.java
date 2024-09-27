import java.util.*;

class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(words));  // Add all words to a set for fast lookup
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (canForm(word, wordSet)) {
                result.add(word);
            }
        }
        
        return result;
    }

    private boolean canForm(String word, Set<String> wordSet) {
        int n = word.length();
        if (n == 0) return false;
        
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Empty string is considered as a valid base case
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i)) && (i - j < n)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[n];
    }
}
