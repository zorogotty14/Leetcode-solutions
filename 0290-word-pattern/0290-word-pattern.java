class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        String[] words = s.split(" ");
        
        
        if (pattern.length() != words.length) {
            return false;
        }
        
        
        HashMap<Character, String> charToWord = new HashMap<>();
        HashMap<String, Character> wordToChar = new HashMap<>();
        
       
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = words[i];
            
            
            if (charToWord.containsKey(c)) {
                if (!charToWord.get(c).equals(word)) {
                    return false;
                }
            } else {
                if (wordToChar.containsKey(word)) {
                    if (wordToChar.get(word) != c) {
                        return false;
                    }
                } else {
                    charToWord.put(c, word);
                    wordToChar.put(word, c);
                }
            }
        }
        
    
        return true;
    }
}