class Solution {
    public String nearestPalindromic(String n) {
        int len = n.length();
        long num = Long.parseLong(n);

        // Candidates to consider
        long[] candidates = new long[5];
        
        // Lower palindrome by decreasing the prefix
        candidates[0] = getPalindrome(Long.parseLong(n.substring(0, (len + 1) / 2)) - 1, len);
        
        // Higher palindrome by increasing the prefix
        candidates[1] = getPalindrome(Long.parseLong(n.substring(0, (len + 1) / 2)) + 1, len);
        
        // Palindrome with the same prefix
        candidates[2] = getPalindrome(Long.parseLong(n.substring(0, (len + 1) / 2)), len);
        
        // Edge cases: All 9's
        candidates[3] = (long) Math.pow(10, len - 1) - 1;
        
        // Edge cases: 100...001
        candidates[4] = (long) Math.pow(10, len) + 1;

        // Find the closest palindrome
        long minDiff = Long.MAX_VALUE;
        long closestPalin = 0;
        
        for (long candidate : candidates) {
            if (candidate == num) continue; // Skip itself
            long diff = Math.abs(candidate - num);
            if (diff < minDiff || (diff == minDiff && candidate < closestPalin)) {
                minDiff = diff;
                closestPalin = candidate;
            }
        }

        return String.valueOf(closestPalin);
    }

    // Helper function to create a palindrome based on the first half
    private long getPalindrome(long prefix, int len) {
        StringBuilder sb = new StringBuilder(String.valueOf(prefix));
        String strPrefix = sb.toString();
        if (len % 2 == 1) {
            sb.deleteCharAt(sb.length() - 1); // remove last digit for odd lengths
        }
        return Long.parseLong(strPrefix + sb.reverse().toString());
    }
}
