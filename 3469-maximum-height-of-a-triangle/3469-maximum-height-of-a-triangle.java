class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(calculateHeight(red, blue, true), calculateHeight(red, blue, false));
    }

    private int calculateHeight(int red, int blue, boolean startWithRed) {
        int height = 0;
        int requiredBalls = 1;

        while (true) {
            if (startWithRed) {
                if (red >= requiredBalls) {
                    red -= requiredBalls;
                } else {
                    break;
                }
            } else {
                if (blue >= requiredBalls) {
                    blue -= requiredBalls;
                } else {
                    break;
                }
            }

            height++;
            requiredBalls++;
            startWithRed = !startWithRed;
        }

        return height;
    }
    
}