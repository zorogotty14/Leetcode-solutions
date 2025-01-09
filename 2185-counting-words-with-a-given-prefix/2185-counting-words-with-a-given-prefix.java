class Solution {
    public int prefixCount(String[] words, String pref) {
        int count = 0;

        // Iterate through each word in the array
        for (String word : words) {
            // Check if the word starts with the given prefix
            if (word.startsWith(pref)) {
                count++;
            }
        }

        return count;
    }
}
