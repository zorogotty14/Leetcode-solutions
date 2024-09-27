import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        // Calculate the total length of all matchsticks
        int totalLength = 0;
        for (int stick : matchsticks) {
            totalLength += stick;
        }
        
        // If the total length is not divisible by 4, it's impossible to form a square
        if (totalLength % 4 != 0) {
            return false;
        }
        
        // Target length for each side of the square
        int target = totalLength / 4;
        
        // Sort the matchsticks in descending order to try larger ones first
        Arrays.sort(matchsticks);
        reverse(matchsticks);  // Sort in descending order
        
        // Array to store the length of each of the 4 sides
        int[] sides = new int[4];
        
        // Start the backtracking process
        return backtrack(matchsticks, sides, 0, target);
    }
    
    private boolean backtrack(int[] matchsticks, int[] sides, int index, int target) {
        // If we've placed all matchsticks, check if all 4 sides are equal to the target
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && sides[2] == target && sides[3] == target;
        }
        
        // Try to place the current matchstick in each side
        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[index] <= target) {
                sides[i] += matchsticks[index];
                if (backtrack(matchsticks, sides, index + 1, target)) {
                    return true;
                }
                sides[i] -= matchsticks[index];  // Backtrack
            }
            // If the current side is 0 or the same as the previous one, stop trying to place the stick in other sides
            if (sides[i] == 0) break;
        }
        
        return false;
    }
    
    private void reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
