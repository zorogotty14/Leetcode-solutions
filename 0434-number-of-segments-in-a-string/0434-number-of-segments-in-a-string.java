class Solution {
    public int countSegments(String s) {
        int count = 0;
        boolean inSegment = false;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (!inSegment) {
                    count++;
                    inSegment = true; // We're now inside a segment
                }
            } else {
                inSegment = false; // We've hit a space, so we're not in a segment
            }
        }
        
        return count;
    }
}
