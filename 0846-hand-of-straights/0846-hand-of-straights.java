import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false; // Total cards must be divisible by groupSize
        }

        // Count the frequency of each card
        Map<Integer, Integer> countMap = new TreeMap<>();
        for (int card : hand) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // Process each card in sorted order
        for (int card : countMap.keySet()) {
            int freq = countMap.get(card);
            if (freq > 0) { // Only process if this card is still available
                // Try to form a group starting from `card`
                for (int i = 0; i < groupSize; i++) {
                    int nextCard = card + i;
                    if (countMap.getOrDefault(nextCard, 0) < freq) {
                        return false; // Not enough cards to form the group
                    }
                    // Decrement the count for the card
                    countMap.put(nextCard, countMap.get(nextCard) - freq);
                }
            }
        }

        return true; // Successfully formed all groups
    }
}
