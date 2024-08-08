class Solution {
    public int minimumPushes(String word) {
       // Count the frequency of each character in the word
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Create a list of the frequencies and sort it in descending order
        List<Map.Entry<Character, Integer>> frequencyList = new ArrayList<>(frequencyMap.entrySet());
        frequencyList.sort((a, b) -> b.getValue() - a.getValue());

        // Initialize the minimum number of pushes
        int minPushes = 0;
        int keyPresses = 1; // Starting from 1 press per key

        for (int i = 0; i < frequencyList.size(); i++) {
            if (i % 8 == 0 && i != 0) {
                keyPresses++;
            }
            minPushes += frequencyList.get(i).getValue() * keyPresses;
        }

        return minPushes;
    }
}