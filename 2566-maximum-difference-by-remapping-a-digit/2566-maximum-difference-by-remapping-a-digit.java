class Solution {
    public int minMaxDifference(int num) {
        String numStr = String.valueOf(num);
        
        // Find maximum value
        int maxVal = getMaxValue(numStr);
        
        // Find minimum value
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
        // Replace the first digit with 0 to minimize the value
        char firstDigit = numStr.charAt(0);
        return Integer.parseInt(numStr.replace(firstDigit, '0'));
    }
}