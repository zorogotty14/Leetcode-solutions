class Solution {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length();
        int n = b.length();
        
        // Calculate the minimum number of repetitions needed
        int minRepeats = (n + m - 1) / m;  // This is equivalent to Math.ceil((double)n / m)
        
        // Build the repeated string with minRepeats
        StringBuilder repeatedA = new StringBuilder();
        for (int i = 0; i < minRepeats; i++) {
            repeatedA.append(a);
        }
        
        // Check if b is a substring
        if (repeatedA.toString().contains(b)) {
            return minRepeats;
        }
        
        // Try one more repetition
        repeatedA.append(a);
        if (repeatedA.toString().contains(b)) {
            return minRepeats + 1;
        }
        
        // If b is not found even after the extra repetition
        return -1;
    }
}
