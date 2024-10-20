import java.util.HashSet;

class Solution {
    public int distributeCandies(int[] candyType) {
        HashSet<Integer> uniqueCandies = new HashSet<>();
        
        // Add all candy types to the set to get unique types
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        
        // Calculate the maximum different types Alice can eat
        return Math.min(uniqueCandies.size(), candyType.length / 2);
    }
}
