class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int length = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentWord = queue.poll();
                if (currentWord.equals(endWord)) {
                    return length;
                }
                for (String neighbor : getNeighbors(currentWord, wordSet)) {
                    queue.add(neighbor);
                }
            }
            length++;
        }
        return 0;
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] wordChars = word.toCharArray();

        for (int i = 0; i < wordChars.length; i++) {
            char originalChar = wordChars[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == originalChar) continue;
                wordChars[i] = c;
                String newWord = new String(wordChars);
                if (wordSet.remove(newWord)) {
                    neighbors.add(newWord);
                }
            }
            wordChars[i] = originalChar;
        }
        return neighbors;
    }
}