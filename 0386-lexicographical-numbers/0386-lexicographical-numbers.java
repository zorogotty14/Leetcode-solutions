import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int curr = 1;
        
        for (int i = 0; i < n; i++) {
            result.add(curr);
            
            if (curr * 10 <= n) {
                curr *= 10; // Move to the next level (from 1 -> 10, 10 -> 100, etc.)
            } else {
                if (curr >= n) {
                    // Move up one level by dividing by 10 until we are in range
                    curr /= 10;
                }
                curr++;
                // Skip numbers ending in 0 or out of bounds
                while (curr % 10 == 0) {
                    curr /= 10;
                }
            }
        }
        
        return result;
    }
}
