class Solution {
    public String optimalDivision(int[] nums) {
        int n = nums.length;
        
        // If there is only one number, return it as a string
        if (n == 1) {
            return Integer.toString(nums[0]);
        }
        
        // If there are only two numbers, just return "a / b"
        if (n == 2) {
            return nums[0] + "/" + nums[1];
        }
        
        // For more than two numbers, use parentheses to maximize the value
        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("/(");  // Start with the first number followed by "/("
        
        // Append the rest of the numbers with "/" in between
        for (int i = 1; i < n; i++) {
            sb.append(nums[i]);
            if (i < n - 1) {
                sb.append("/");
            }
        }
        
        sb.append(")");  // Close the parenthesis

        return sb.toString();
    }
}
