class Solution {
    public String toGoatLatin(String sentence) {
        // Define vowels for quick lookup
        String vowels = "aeiouAEIOU";
        
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Use a StringBuilder to construct the result
        StringBuilder result = new StringBuilder();
        
        // Process each word
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            StringBuilder transformedWord = new StringBuilder();
            
            // Check if the first letter is a vowel
            if (vowels.indexOf(word.charAt(0)) != -1) {
                // Starts with a vowel
                transformedWord.append(word);
            } else {
                // Starts with a consonant
                transformedWord.append(word.substring(1)).append(word.charAt(0));
            }
            
            // Append "ma"
            transformedWord.append("ma");
            
            // Append "a" repeated (i + 1) times
            for (int j = 0; j <= i; j++) {
                transformedWord.append('a');
            }
            
            // Add the transformed word to the result
            result.append(transformedWord);
            
            // Add a space if not the last word
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        
        // Return the final string
        return result.toString();
    }
}
