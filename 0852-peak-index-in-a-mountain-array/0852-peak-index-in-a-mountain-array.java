class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If mid is increasing, the peak must be on the right side
            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                // If mid is decreasing, the peak must be on the left side
                right = mid;
            }
        }

        // At the end, left == right, which is the peak index
        return left;
    }
}
