import java.util.HashMap;
import java.util.Map;

class Solution {
    private Map<Integer, Boolean> memo;
    
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        // If the sum of all integers is less than the desired total, no one can win
        int sum = (maxChoosableInteger * (maxChoosableInteger + 1)) / 2;
        if (sum < desiredTotal) return false;
        
        // If the desired total is zero or less, the first player wins immediately
        if (desiredTotal <= 0) return true;
        
        // Initialize memoization map
        memo = new HashMap<>();
        
        // Start the recursive game simulation with no numbers picked (0 bitmask) and desired total
        return canWin(0, maxChoosableInteger, desiredTotal);
    }
    
    // Recursive helper function to determine if the current player can win from the given state
    private boolean canWin(int usedNumbers, int maxChoosableInteger, int desiredTotal) {
        // If this state has been computed before, return the stored result
        if (memo.containsKey(usedNumbers)) {
            return memo.get(usedNumbers);
        }
        
        // Try picking each available number and check if the opponent loses after that
        for (int i = 1; i <= maxChoosableInteger; i++) {
            // Calculate the bitmask for the current number (1 << (i-1)) and check if it has been used
            if ((usedNumbers & (1 << (i - 1))) == 0) {  // If this number hasn't been used
                // If picking this number makes the total >= desiredTotal, or the opponent cannot win after this move
                if (i >= desiredTotal || !canWin(usedNumbers | (1 << (i - 1)), maxChoosableInteger, desiredTotal - i)) {
                    memo.put(usedNumbers, true);
                    return true;
                }
            }
        }
        
        // If no winning move was found, the current player loses in this state
        memo.put(usedNumbers, false);
        return false;
    }
}
