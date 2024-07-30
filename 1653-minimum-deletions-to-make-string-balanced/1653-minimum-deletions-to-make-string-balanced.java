class Solution {
    public int minimumDeletions(String s) {
        int totalA = 0;
        for (char c : s.toCharArray()) {
            if (c == 'a') {
                totalA++;
            }
        }
        
        int minDeletions = totalA; // Start with the idea of deleting all 'a's to be safe
        int bCount = 0;
        int aCount = totalA;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else {
                aCount--;
            }
            minDeletions = Math.min(minDeletions, bCount + aCount);
        }
        
        return minDeletions;
    }
}