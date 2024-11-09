import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

class Solution {
    private HashMap<Integer, Integer> mapping;
    private int rangeSize;
    private Random random;

    public Solution(int n, int[] blacklist) {
        mapping = new HashMap<>();
        random = new Random();
        rangeSize = n - blacklist.length;

        HashSet<Integer> blacklistedSet = new HashSet<>();
        for (int b : blacklist) {
            if (b >= rangeSize) {
                blacklistedSet.add(b);
            }
        }

        int available = rangeSize;
        for (int b : blacklist) {
            if (b < rangeSize) {
                while (blacklistedSet.contains(available)) {
                    available++;
                }
                mapping.put(b, available);
                available++;
            }
        }
    }
    
    public int pick() {
        int randIndex = random.nextInt(rangeSize);
        return mapping.getOrDefault(randIndex, randIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n, blacklist);
 * int param_1 = obj.pick();
 */
