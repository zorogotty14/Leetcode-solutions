class Solution {
    public void findSecretWord(String[] words, Master master) {
        // Initialize the list of candidates
        List<String> candidates = new ArrayList<>(Arrays.asList(words));

        // Iterate up to the allowed number of guesses
        for (int i = 0; i < 10; i++) {
            // Choose the first candidate (or implement a smarter strategy)
            String guessWord = candidates.get(0);

            // Call the Master API
            int matches = master.guess(guessWord);

            // If all characters match, we've found the secret word
            if (matches == 6) {
                return;
            }

            // Filter the candidates based on the number of matches
            List<String> newCandidates = new ArrayList<>();
            for (String word : candidates) {
                if (countMatches(guessWord, word) == matches) {
                    newCandidates.add(word);
                }
            }

            // Update the candidates for the next iteration
            candidates = newCandidates;
        }
    }

    private int countMatches(String word1, String word2) {
        int matches = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                matches++;
            }
        }
        return matches;
    }
}
