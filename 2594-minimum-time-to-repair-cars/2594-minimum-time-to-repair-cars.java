class Solution {
    public long repairCars(int[] ranks, int cars) {
        long left = 1, right = (long) 1e14; // Upper bound estimate
        long result = right;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (canRepairAllCars(ranks, cars, mid)) {
                result = mid; // Update result with smaller feasible time
                right = mid - 1; // Try a smaller time
            } else {
                left = mid + 1; // Increase time
            }
        }
        return result;
    }

    private boolean canRepairAllCars(int[] ranks, int cars, long time) {
        long totalCarsRepaired = 0;
        for (int rank : ranks) {
            totalCarsRepaired += (long) Math.sqrt(time / rank); // Max cars a mechanic can repair in 'time'
            if (totalCarsRepaired >= cars) {
                return true; // If we can repair all cars, return early
            }
        }
        return totalCarsRepaired >= cars;
    }
}
