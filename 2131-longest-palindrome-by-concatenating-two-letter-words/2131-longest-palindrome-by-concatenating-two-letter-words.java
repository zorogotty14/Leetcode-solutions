class Solution {
    public int longestPalindrome(String[] words) {
        // Count frequency of each word
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        
        int result = 0;
        boolean hasMiddle = false;
        
        for (String word : count.keySet()) {
            int freq = count.get(word);
            
            // Case 1: Self-palindromic words (like "aa", "bb", "cc")
            if (word.charAt(0) == word.charAt(1)) {
                // We can use pairs of these words
                int pairs = freq / 2;
                result += pairs * 4; // Each pair contributes 4 characters (2 words * 2 chars each)
                
                // If there's an odd count and we haven't used a middle word yet
                if (freq % 2 == 1 && !hasMiddle) {
                    result += 2; // Use one word in the middle
                    hasMiddle = true;
                }
            }
            // Case 2: Non-palindromic words that can form pairs with their reverse
            else {
                String reverse = "" + word.charAt(1) + word.charAt(0);
                
                // Only process if we haven't processed the reverse yet (to avoid double counting)
                if (count.containsKey(reverse) && word.compareTo(reverse) < 0) {
                    int reverseFreq = count.get(reverse);
                    int pairs = Math.min(freq, reverseFreq);
                    result += pairs * 4; // Each pair contributes 4 characters
                }
            }
        }
        
        return result;
    }
}