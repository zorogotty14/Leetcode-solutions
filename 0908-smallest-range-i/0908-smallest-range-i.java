class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num > maxVal) maxVal = num;
            if (num < minVal) minVal = num;
        }
        
        // The gap can be shrunk by up to 2*k
        int diff = maxVal - minVal;
        int answer = diff - 2*k;
        if (answer < 0) answer = 0;
        return answer;
    }
}
