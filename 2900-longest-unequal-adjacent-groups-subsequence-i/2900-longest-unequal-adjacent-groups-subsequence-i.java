class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<String> result = new ArrayList<>();
        
        // If there's only one element, return it
        if (n == 1) {
            result.add(words[0]);
            return result;
        }
        
        // Use a greedy approach
        // Start with the first element
        result.add(words[0]);
        int lastGroup = groups[0];
        
        // Iterate through the remaining elements
        for (int i = 1; i < n; i++) {
            // If the current element has a different group than the last added element
            if (groups[i] != lastGroup) {
                result.add(words[i]);
                lastGroup = groups[i]; // Update the last group
            }
        }
        
        return result;
    }
}