class Solution {
    public int maxDistToClosest(int[] seats) {
        int maxDistance = 0;
        int lastOccupied = -1; // Tracks the last occupied seat index

        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (lastOccupied == -1) {
                    // Case 1: If this is the first occupied seat, maxDistance is i
                    maxDistance = i;
                } else {
                    // Case 2: Calculate the distance to the closest person
                    maxDistance = Math.max(maxDistance, (i - lastOccupied) / 2);
                }
                lastOccupied = i; // Update the last occupied index
            }
        }

        // Case 3: If there are empty seats at the end
        maxDistance = Math.max(maxDistance, seats.length - 1 - lastOccupied);

        return maxDistance;
    }
}
