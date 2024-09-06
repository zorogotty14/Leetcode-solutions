class Solution {
    public boolean isPerfectSquare(int num) {
        // Edge case
        if (num == 1) {
            return true;
        }
        
        long left = 1;
        long right = num;
        
        // Binary search for a number whose square is equal to num
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long squared = mid * mid;
            
            if (squared == num) {
                return true;
            } else if (squared > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        // If no perfect square was found, return false
        return false;
    }
}
