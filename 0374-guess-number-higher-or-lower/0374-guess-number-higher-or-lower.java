public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int low = 1, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2; // Avoid potential overflow with (low + high) / 2
            int res = guess(mid);
            if (res == 0) {
                return mid; // Correct guess
            } else if (res == -1) {
                high = mid - 1; // The picked number is lower than mid
            } else {
                low = mid + 1; // The picked number is higher than mid
            }
        }
        return -1; // Should never reach here if input is valid
    }
}