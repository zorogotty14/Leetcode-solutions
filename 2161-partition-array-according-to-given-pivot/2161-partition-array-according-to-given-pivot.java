class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        // Step 1: Create three lists to hold elements less than, equal to, and greater than the pivot
        List<Integer> less = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        
        // Step 2: Iterate through nums and populate the lists
        for (int num : nums) {
            if (num < pivot) {
                less.add(num);
            } else if (num == pivot) {
                equal.add(num);
            } else {
                greater.add(num);
            }
        }
        
        // Step 3: Prepare the result array
        int[] result = new int[nums.length];
        int index = 0;
        
        // Step 4: Add elements to the result array in the required order
        for (int num : less) {
            result[index++] = num;
        }
        
        for (int num : equal) {
            result[index++] = num;
        }
        
        for (int num : greater) {
            result[index++] = num;
        }
        
        return result;
    }
}
