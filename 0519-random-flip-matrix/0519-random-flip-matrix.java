import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Solution {
    private int m, n, total;
    private Map<Integer, Integer> map;
    private Random rand;

    public Solution(int m, int n) {
        this.m = m;
        this.n = n;
        this.total = m * n;
        this.map = new HashMap<>();
        this.rand = new Random();
    }
    
    public int[] flip() {
        int r = rand.nextInt(total);  // Pick a random index in the range [0, total-1]
        total--;  // Decrease the total number of available cells

        // Find the real index to return
        int idx = map.getOrDefault(r, r);
        
        // Map the chosen index to the last available one
        map.put(r, map.getOrDefault(total, total));
        
        // Convert the 1D index to 2D coordinates (i, j)
        return new int[]{idx / n, idx % n};
    }
    
    public void reset() {
        map.clear();  // Clear the mapping
        total = m * n;  // Reset the total available cells
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(m, n);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */
