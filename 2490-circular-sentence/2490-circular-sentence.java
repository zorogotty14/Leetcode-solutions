class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Check each consecutive pair of words
        for (int i = 0; i < words.length - 1; i++) {
            // Check if the last character of the current word 
            // matches the first character of the next word
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false;
            }
        }
        
        // Check if the last character of the last word matches 
        // the first character of the first word for circularity
        return words[words.length - 1].charAt(words[words.length - 1].length() - 1) == words[0].charAt(0);
    }
}
