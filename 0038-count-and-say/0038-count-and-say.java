class Solution {
    
    public String countAndSay(int n) {
        if (n <= 0) {
            return "";
        }
        
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = getNextSequence(result);
        }
        
        return result;
    }

    private String getNextSequence(String sequence) {
        StringBuilder nextSequence = new StringBuilder();
        int count = 1;
        
        for (int i = 1; i < sequence.length(); i++) {
            if (sequence.charAt(i) == sequence.charAt(i - 1)) {
                count++;
            } else {
                nextSequence.append(count).append(sequence.charAt(i - 1));
                count = 1;
            }
        }
        
        nextSequence.append(count).append(sequence.charAt(sequence.length() - 1));
        
        return nextSequence.toString();
    }
}