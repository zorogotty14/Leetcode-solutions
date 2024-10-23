class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length; i++) {
            // Check if we can plant a flower at index i
            if (flowerbed[i] == 0 &&
                (i == 0 || flowerbed[i - 1] == 0) &&
                (i == length - 1 || flowerbed[i + 1] == 0)) {

                // Plant a flower and mark this plot as occupied
                flowerbed[i] = 1;
                n--;  // Decrease the remaining flowers to be planted
                
                // If we have planted all the flowers, return true
                if (n == 0) {
                    return true;
                }
            }
        }

        // If we finish the loop and still have flowers to plant, return false
        return n <= 0;
    }
}
