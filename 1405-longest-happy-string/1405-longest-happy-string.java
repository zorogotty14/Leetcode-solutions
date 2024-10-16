import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Create a max heap (priority queue) to store characters with their remaining counts
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        
        // Add 'a', 'b', and 'c' with their counts to the heap if they are non-zero
        if (a > 0) pq.offer(new int[]{'a', a});
        if (b > 0) pq.offer(new int[]{'b', b});
        if (c > 0) pq.offer(new int[]{'c', c});
        
        StringBuilder result = new StringBuilder();
        
        while (!pq.isEmpty()) {
            // Take the character with the highest count
            int[] first = pq.poll();
            char ch1 = (char) first[0];
            int count1 = first[1];
            
            // Check if we can safely add this character (no triple repetition)
            int n = result.length();
            if (n >= 2 && result.charAt(n - 1) == ch1 && result.charAt(n - 2) == ch1) {
                // If adding ch1 would create a triple, we need to try the next character
                if (pq.isEmpty()) {
                    break;  // No other character to add, so stop
                }
                
                // Get the next character with the second highest count
                int[] second = pq.poll();
                char ch2 = (char) second[0];
                int count2 = second[1];
                
                // Add ch2 to the result
                result.append(ch2);
                count2--;
                
                // Put the second character back into the heap if we still have more of it
                if (count2 > 0) {
                    pq.offer(new int[]{ch2, count2});
                }
                
                // Also put the first character back into the heap, since we didn't use it
                pq.offer(first);
            } else {
                // Safe to add the first character
                result.append(ch1);
                count1--;
                
                // If we still have more of this character, add it back to the heap
                if (count1 > 0) {
                    pq.offer(new int[]{ch1, count1});
                }
            }
        }
        
        return result.toString();
    }
}
