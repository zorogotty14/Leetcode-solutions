class Solution {
    public int thirdMax(int[] nums) {
        // Initialize three variables to track the first, second, and third max values
        Integer first = null, second = null, third = null;
        
        for (int num : nums) {
            // Ignore duplicates
            if ((first != null && num == first) || 
                (second != null && num == second) || 
                (third != null && num == third)) {
                continue;
            }
            
            // Update the three largest distinct values
            if (first == null || num > first) {
                third = second;
                second = first;
                first = num;
            } else if (second == null || num > second) {
                third = second;
                second = num;
            } else if (third == null || num > third) {
                third = num;
            }
        }
        
        // If third is null, return the first (the largest number)
        return third == null ? first : third;
    }
}
