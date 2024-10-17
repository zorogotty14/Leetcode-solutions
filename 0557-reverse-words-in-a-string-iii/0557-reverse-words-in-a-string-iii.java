class Solution {
    public String reverseWords(String s) {
        // Split the sentence into words
        String[] words = s.split(" ");
        
        // Use a StringBuilder to efficiently reverse each word
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < words.length; i++) {
            // Reverse the current word and append it to the result
            result.append(new StringBuilder(words[i]).reverse());
            
            // Add a space after each word except the last one
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        // Convert the result back to a string and return
        return result.toString();
    }
}
