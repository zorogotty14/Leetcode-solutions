import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        // Use a max-heap (priority queue with reversed order) to track the largest pile of gifts
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all piles to the max-heap
        for (int gift : gifts) {
            maxHeap.add(gift);
        }
        
        // Perform the operation k times
        for (int i = 0; i < k; i++) {
            if (maxHeap.isEmpty()) break;
            
            // Take the maximum pile
            int maxGift = maxHeap.poll();
            int remainingGifts = (int) Math.floor(Math.sqrt(maxGift));
            
            // Add the remaining gifts back to the heap
            maxHeap.add(remainingGifts);
        }
        
        // Sum up the remaining gifts
        long totalRemainingGifts = 0;
        while (!maxHeap.isEmpty()) {
            totalRemainingGifts += maxHeap.poll();
        }
        
        return totalRemainingGifts;
    }
}
