class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[] prevIndex = new int[26]; // Last occurrence of each character
        int[] nextIndex = new int[26]; // Next occurrence of each character
        
        // Initialize prevIndex to -1 (no occurrence before start)
        Arrays.fill(prevIndex, -1);
        // Initialize nextIndex to n (no occurrence after end)
        Arrays.fill(nextIndex, n);
        
        // Result variable
        int result = 0;
        int MOD = 1_000_000_007;
        
        // Store next occurrence of each character
        int[] nextPos = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int charIndex = s.charAt(i) - 'A';
            nextPos[i] = nextIndex[charIndex];
            nextIndex[charIndex] = i;
        }
        
        // Calculate contributions
        for (int i = 0; i < n; i++) {
            int charIndex = s.charAt(i) - 'A';
            int left = i - prevIndex[charIndex];
            int right = nextPos[i] - i;
            result = (result + left * right) % MOD;
            prevIndex[charIndex] = i;
        }
        
        return result;
    }
}
