import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] counts = new Integer[n];
        int[] indices = new int[n];
        
        for (int i = 0; i < n; i++) {
            indices[i] = i;
            counts[i] = 0;
        }
        
        mergeSort(nums, indices, counts, 0, n - 1);
        
        List<Integer> result = new ArrayList<>();
        for (int count : counts) {
            result.add(count);
        }
        return result;
    }
    
    private void mergeSort(int[] nums, int[] indices, Integer[] counts, int left, int right) {
        if (left >= right) return;
        
        int mid = (left + right) / 2;
        mergeSort(nums, indices, counts, left, mid);
        mergeSort(nums, indices, counts, mid + 1, right);
        merge(nums, indices, counts, left, mid, right);
    }
    
    private void merge(int[] nums, int[] indices, Integer[] counts, int left, int mid, int right) {
        int[] newIndices = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        int rightCounter = 0;
        
        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                newIndices[k++] = indices[j++];
                rightCounter++;
            } else {
                counts[indices[i]] += rightCounter;
                newIndices[k++] = indices[i++];
            }
        }
        
        while (i <= mid) {
            counts[indices[i]] += rightCounter;
            newIndices[k++] = indices[i++];
        }
        
        while (j <= right) {
            newIndices[k++] = indices[j++];
        }
        
        System.arraycopy(newIndices, 0, indices, left, newIndices.length);
    }
}
