class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // Split both sentences into words
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        int i = 0; // Pointer to start from the beginning
        int j = 0; // Pointer to start from the end
        
        // Match words from the start
        while (i < words1.length && i < words2.length && words1[i].equals(words2[i])) {
            i++;
        }
        
        // Match words from the end
        while (j < words1.length - i && j < words2.length - i && 
               words1[words1.length - 1 - j].equals(words2[words2.length - 1 - j])) {
            j++;
        }
        
        // If the remaining unmatched part can be inserted in one sentence, return true
        return i + j >= Math.min(words1.length, words2.length);
    }
}
