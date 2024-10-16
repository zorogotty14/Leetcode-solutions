class Solution {
    public boolean checkRecord(String s) {
        int absents = 0;  // Counter for 'A'
        int lateStreak = 0;  // Counter for consecutive 'L'
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'A') {
                absents++;  // Increment absent count
                if (absents >= 2) {
                    return false;  // If 2 or more absents, return false immediately
                }
            }
            
            if (c == 'L') {
                lateStreak++;  // Increment consecutive late count
                if (lateStreak >= 3) {
                    return false;  // If 3 or more consecutive 'L's, return false
                }
            } else {
                lateStreak = 0;  // Reset the streak if the current char is not 'L'
            }
        }
        
        return true;  // Eligible if none of the conditions disqualify the student
    }
}
