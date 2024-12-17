import java.util.PriorityQueue;

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        // Frequency count of characters
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        // Max Heap: store characters and their frequencies, sorted lexicographically
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                maxHeap.offer(new int[]{i, freq[i]}); // {character, frequency}
            }
        }

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            int[] largest = maxHeap.poll(); // Get the largest character
            int charIndex = largest[0];
            int charFreq = largest[1];

            int limit = Math.min(charFreq, repeatLimit);

            // Append the character 'limit' times
            for (int i = 0; i < limit; i++) {
                result.append((char) (charIndex + 'a'));
            }

            // Reduce the frequency
            charFreq -= limit;

            if (charFreq > 0) {
                if (maxHeap.isEmpty()) break; // No other character to break the repetition

                // Use the next largest character to break the repetition
                int[] secondLargest = maxHeap.poll();
                int secondCharIndex = secondLargest[0];
                int secondCharFreq = secondLargest[1];

                // Append one instance of the second largest character
                result.append((char) (secondCharIndex + 'a'));
                secondCharFreq--;

                // Reinsert the second largest character if it still has remaining count
                if (secondCharFreq > 0) {
                    maxHeap.offer(new int[]{secondCharIndex, secondCharFreq});
                }

                // Reinsert the largest character with updated frequency
                maxHeap.offer(new int[]{charIndex, charFreq});
            }
        }

        return result.toString();
    }
}
