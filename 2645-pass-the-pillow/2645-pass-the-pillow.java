class Solution {
    public int passThePillow(int n, int time) {
        // Initial conditions
        int position = 1;
        boolean forward = true;

        // Simulate each second of passing the pillow
        for (int i = 0; i < time; i++) {
            if (forward) {
                if (position == n) {
                    // Reverse direction when reaching the end
                    forward = false;
                    position--;
                } else {
                    position++;
                }
            } else {
                if (position == 1) {
                    // Reverse direction when reaching the start
                    forward = true;
                    position++;
                } else {
                    position--;
                }
            }
        }

        return position;
    }
}