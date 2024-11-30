import java.util.*;

class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        backtrack(num, result, 0);
        return result;
    }

    private boolean backtrack(String num, List<Integer> sequence, int index) {
        if (index == num.length() && sequence.size() >= 3) {
            return true; // Found a valid sequence
        }

        for (int i = index; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (num.charAt(index) == '0' && i > index) break;

            // Parse the current number
            long currentNum = Long.parseLong(num.substring(index, i + 1));

            // Stop if the number exceeds the 32-bit integer limit
            if (currentNum > Integer.MAX_VALUE) break;

            int size = sequence.size();

            // Check if the current number fits the Fibonacci property
            if (size >= 2 && currentNum > (long) sequence.get(size - 1) + sequence.get(size - 2)) break;

            if (size <= 1 || currentNum == (long) sequence.get(size - 1) + sequence.get(size - 2)) {
                // Add the number to the sequence
                sequence.add((int) currentNum);

                // Recursively try to build the sequence
                if (backtrack(num, sequence, i + 1)) {
                    return true;
                }

                // Backtrack
                sequence.remove(sequence.size() - 1);
            }
        }

        return false;
    }
}
