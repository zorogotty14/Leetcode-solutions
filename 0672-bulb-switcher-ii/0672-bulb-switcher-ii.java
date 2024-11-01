class Solution {
    public int flipLights(int n, int presses) {
        if (presses == 0) return 1; // No presses, only one state
        if (n == 1) return 2;       // Only 1 bulb, either on or off
        if (n == 2) {
            return presses == 1 ? 3 : 4; // 3 states with 1 press, 4 with 2 or more
        }
        // For n >= 3:
        if (presses == 1) return 4;     // 4 distinct states with 1 press
        if (presses == 2) return 7;     // 7 distinct states with 2 presses
        return 8;                       // 8 distinct states with 3 or more presses
    }
}
