class Solution {
    public int[] constructRectangle(int area) {
        // Start from the square root of the area and go downwards
        int W = (int) Math.sqrt(area);
        // Find the largest W such that area % W == 0
        while (area % W != 0) {
            W--;
        }
        // The corresponding L will be area / W
        int L = area / W;
        return new int[]{L, W};
    }
}
