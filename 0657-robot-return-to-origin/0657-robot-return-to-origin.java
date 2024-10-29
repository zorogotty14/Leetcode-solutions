class Solution {
    public boolean judgeCircle(String moves) {
        // Variables to track the robot's position
        int x = 0; // x-axis position
        int y = 0; // y-axis position

        // Iterate over each move in the string
        for (char move : moves.toCharArray()) {
            // Update the position based on the move
            if (move == 'U') {
                y++; // Move up increases y-coordinate
            } else if (move == 'D') {
                y--; // Move down decreases y-coordinate
            } else if (move == 'L') {
                x--; // Move left decreases x-coordinate
            } else if (move == 'R') {
                x++; // Move right increases x-coordinate
            }
        }

        // If the robot is back at the origin (0, 0), return true
        return x == 0 && y == 0;
    }
}
