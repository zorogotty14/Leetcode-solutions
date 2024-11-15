import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains("0000")) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");
        
        int moves = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                if (current.equals(target)) {
                    return moves;
                }
                for (String next : getNextStates(current)) {
                    if (!visited.contains(next) && !deadSet.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }

    private List<String> getNextStates(String current) {
        List<String> nextStates = new ArrayList<>();
        char[] chars = current.toCharArray();
        for (int i = 0; i < 4; i++) {
            char original = chars[i];
            // Turn the wheel forward
            chars[i] = original == '9' ? '0' : (char)(original + 1);
            nextStates.add(new String(chars));
            // Turn the wheel backward
            chars[i] = original == '0' ? '9' : (char)(original - 1);
            nextStates.add(new String(chars));
            // Restore original state
            chars[i] = original;
        }
        return nextStates;
    }
}
