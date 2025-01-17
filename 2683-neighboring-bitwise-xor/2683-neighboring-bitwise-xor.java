class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xorSum = 0;
        for (int val : derived) {
            xorSum ^= val;
        }
        // If xorSum == 0, a valid original array exists
        return xorSum == 0;
    }
}
