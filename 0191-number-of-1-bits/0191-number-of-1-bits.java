class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count++;
            n &= (n - 1); // Turn off the rightmost set bit
        }
        return count;
    }
}