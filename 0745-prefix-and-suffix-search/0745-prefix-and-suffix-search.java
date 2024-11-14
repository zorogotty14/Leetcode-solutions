import java.util.HashMap;

class WordFilter {
    private HashMap<String, Integer> map;

    public WordFilter(String[] words) {
        map = new HashMap<>();
        // Store all combinations of prefix and suffix along with the index
        for (int index = 0; index < words.length; index++) {
            String word = words[index];
            // Generate all possible prefix and suffix combinations
            for (int i = 0; i <= word.length(); i++) {
                String prefix = word.substring(0, i);
                for (int j = 0; j <= word.length(); j++) {
                    String suffix = word.substring(j);
                    // Use a unique key for each prefix-suffix combination
                    map.put(prefix + "#" + suffix, index);
                }
            }
        }
    }

    public int f(String pref, String suff) {
        // Check if the combination exists in the map
        String key = pref + "#" + suff;
        return map.getOrDefault(key, -1);
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
