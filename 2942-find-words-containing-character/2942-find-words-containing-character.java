class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        
        // Iterate through each word with its index
        for (int i = 0; i < words.length; i++) {
            // Check if the current word contains the character x
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        
        return result;
    }
}