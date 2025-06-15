class Solution {
    public int maxDiff(int num) {
        String numStr = String.valueOf(num);
        
        // Get maximum value
        int maxVal = getMaxValue(numStr);
        
        // Get minimum value
        int minVal = getMinValue(numStr);
        
        return maxVal - minVal;
    }
    
    private int getMaxValue(String numStr) {
        // Find the first digit that is not 9 and replace all occurrences with 9
        for (char c : numStr.toCharArray()) {
            if (c != '9') {
                return Integer.parseInt(numStr.replace(c, '9'));
            }
        }
        // If all digits are 9, no change needed
        return Integer.parseInt(numStr);
    }
    
    private int getMinValue(String numStr) {
        char firstDigit = numStr.charAt(0);
        
        // If first digit is greater than 1, replace it with 1
        if (firstDigit > '1') {
            return Integer.parseInt(numStr.replace(firstDigit, '1'));
        }
        
        // If first digit is 1, find the first digit that is not 0 or 1
        // and replace all occurrences with 0
        for (int i = 1; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if (c != '0' && c != '1') {
                return Integer.parseInt(numStr.replace(c, '0'));
            }
        }
        
        // If no such digit found, return the original number
        return Integer.parseInt(numStr);
    }
}