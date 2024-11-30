class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] forces = new int[n];

        // Step 1: Calculate forces moving rightward
        int force = 0;
        for (int i = 0; i < n; i++) {
            if (dominoes.charAt(i) == 'R') {
                force = n; // Maximum force for a push
            } else if (dominoes.charAt(i) == 'L') {
                force = 0; // Reset force as 'L' cancels rightward pushes
            } else {
                force = Math.max(force - 1, 0); // Diminishing force
            }
            forces[i] += force;
        }

        // Step 2: Calculate forces moving leftward
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (dominoes.charAt(i) == 'L') {
                force = -n; // Maximum negative force for a push
            } else if (dominoes.charAt(i) == 'R') {
                force = 0; // Reset force as 'R' cancels leftward pushes
            } else {
                force = Math.min(force + 1, 0); // Diminishing force
            }
            forces[i] += force;
        }

        // Step 3: Determine the final state of the dominoes
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) {
                result.append('R');
            } else if (f < 0) {
                result.append('L');
            } else {
                result.append('.');
            }
        }

        return result.toString();
    }
}
