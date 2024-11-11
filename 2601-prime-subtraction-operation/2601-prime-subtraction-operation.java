import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean primeSubOperation(int[] nums) {
        // Generate a list of primes less than 1000
        List<Integer> primes = sieveOfEratosthenes(1000);

        // Initialize previous value for strictly increasing check
        int prev = 0;

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Find the maximum prime that can be subtracted from nums[i]
            // such that the result is greater than prev
            boolean modified = false;
            for (int j = primes.size() - 1; j >= 0; j--) {
                int prime = primes.get(j);
                if (prime < nums[i] && nums[i] - prime > prev) {
                    nums[i] -= prime;
                    modified = true;
                    break;
                }
            }

            // If no modification was made and nums[i] <= prev, return false
            if (!modified && nums[i] <= prev) {
                return false;
            }

            // Update prev to the current nums[i]
            prev = nums[i];
        }

        return true;
    }

    // Function to generate prime numbers up to n using the Sieve of Eratosthenes
    private List<Integer> sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
