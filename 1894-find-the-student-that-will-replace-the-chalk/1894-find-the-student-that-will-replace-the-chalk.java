class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // Step 1: Calculate the total chalk used in one complete round
        long totalChalk = 0;
        for (int c : chalk) {
            totalChalk += c;
        }
        
        // Step 2: Reduce k using modulus
        k %= totalChalk;
        
        // Step 3: Find the student who will replace the chalk
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k -= chalk[i];
        }
        
        // This line is never reached because the function must return within the loop
        return -1;
    }
}
