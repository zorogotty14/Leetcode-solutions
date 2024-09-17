class Solution {
    public int strongPasswordChecker(String password) {
        int n = password.length();
        
        // Flags for character types
        boolean hasLower = false, hasUpper = false, hasDigit = false;
        
        // Track repeating characters (three in a row)
        int replace = 0, oneMod3 = 0, twoMod3 = 0;
        int repeat = 0;
        
        // Check for character types and repeating sequences
        for (int i = 0; i < n; ) {
            if (Character.isLowerCase(password.charAt(i))) hasLower = true;
            if (Character.isUpperCase(password.charAt(i))) hasUpper = true;
            if (Character.isDigit(password.charAt(i))) hasDigit = true;
            
            int j = i;
            while (i < n && password.charAt(i) == password.charAt(j)) i++;
            int len = i - j;  // Length of the repeating characters
            
            if (len >= 3) {
                replace += len / 3;  // Number of replacements needed to break repeating sequences
                if (len % 3 == 0) oneMod3++;
                else if (len % 3 == 1) twoMod3++;
            }
        }
        
        // How many character types are missing
        int missingTypes = (hasLower ? 0 : 1) + (hasUpper ? 0 : 1) + (hasDigit ? 0 : 1);
        
        if (n < 6) {
            // If the password is too short, we need to insert characters
            return Math.max(missingTypes, 6 - n);
        } else if (n <= 20) {
            // If the length is within the acceptable range
            return Math.max(missingTypes, replace);
        } else {
            // If the password is too long, we need to delete characters
            int delete = n - 20;
            
            // First, try to remove the repeating sequences as efficiently as possible
            replace -= Math.min(delete, oneMod3);
            replace -= Math.min(Math.max(delete - oneMod3, 0), twoMod3 * 2) / 2;
            replace -= Math.max(delete - oneMod3 - twoMod3 * 2, 0) / 3;
            
            return delete + Math.max(missingTypes, replace);
        }
    }
}
