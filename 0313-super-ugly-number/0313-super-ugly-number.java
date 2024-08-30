import java.util.*;

class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] uglyNumbers = new long[n];
        uglyNumbers[0] = 1;
        
        int[] indexes = new int[primes.length]; // To track the position for each prime
        long[] values = new long[primes.length];  // Current values for each prime multiplication
        
        // Initialize the values array
        for (int i = 0; i < primes.length; i++) {
            values[i] = primes[i];
        }
        
        for (int i = 1; i < n; i++) {
            // Find the minimum value in the current list of values
            long minValue = Long.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                if (values[j] < minValue) {
                    minValue = values[j];
                }
            }
            
            uglyNumbers[i] = minValue;
            
            // Update the indexes and values array
            for (int j = 0; j < primes.length; j++) {
                if (values[j] == minValue) {
                    indexes[j]++;
                    values[j] = uglyNumbers[indexes[j]] * primes[j];
                }
            }
        }
        
        return (int) uglyNumbers[n - 1];
    }
}
