class Solution {
    public int getSum(int a, int b) {
        while (b != 0) {
            // Calculate carry
            int carry = (a & b) << 1;
            
            // Calculate sum without considering carry
            a = a ^ b;
            
            // Update b to carry
            b = carry;
        }
        return a;
    }
}