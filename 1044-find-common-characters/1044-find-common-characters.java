class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26]; 
        for (int i = 0; i < 26; i++) {
            minFreq[i] = Integer.MAX_VALUE; 
        }

        for (String word : words) {
            int[] charCount = new int[26]; 
            for (char c : word.toCharArray()) {
                charCount[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], charCount[i]);
            }
        }

        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < minFreq[i]; j++) {
                result.add(String.valueOf((char) (i + 'a')));
            }
        }
        return result;
    }
}