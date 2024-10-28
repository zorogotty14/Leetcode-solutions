import java.util.*;

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        int n = senate.length();

        // Add the indexes of Radiant and Dire senators to their respective queues
        for (int i = 0; i < n; i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }

        // Process the senate voting round by round
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int rIndex = radiant.poll();
            int dIndex = dire.poll();

            // The senator with the smaller index gets to ban the other
            if (rIndex < dIndex) {
                // Radiant senator bans Dire senator and moves to the next round
                radiant.offer(rIndex + n);
            } else {
                // Dire senator bans Radiant senator and moves to the next round
                dire.offer(dIndex + n);
            }
        }

        // Determine the winning party
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
