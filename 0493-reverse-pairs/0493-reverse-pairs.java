class Solution {
    public int reversePairs(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int left, int right) {
        if (left >= right) return 0;

        int mid = left + (right - left) / 2;
        int count = 0;
        
        // Recursively split and count reverse pairs in both halves
        count += mergeSort(nums, left, mid);
        count += mergeSort(nums, mid + 1, right);

        // Count reverse pairs across the left and right halves
        count += countWhileMerging(nums, left, mid, right);

        // Merge the two halves
        merge(nums, left, mid, right);
        
        return count;
    }

    private int countWhileMerging(int[] nums, int left, int mid, int right) {
        int count = 0;
        int j = mid + 1;

        // For each element in the left half, count how many elements in the right half satisfy nums[i] > 2 * nums[j]
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += (j - (mid + 1));
        }

        return count;
    }

    private void merge(int[] nums, int left, int mid, int right) {
        // Merge two sorted subarrays: nums[left..mid] and nums[mid+1..right]
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;

        // Standard merge sort merge process
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        // Copy any remaining elements from the left half
        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        // Copy any remaining elements from the right half
        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // Copy the sorted subarray back into the original array
        System.arraycopy(temp, 0, nums, left, temp.length);
    }
}
