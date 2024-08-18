import java.util.PriorityQueue;
import java.util.HashSet;

class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        
        PriorityQueue<Long> heap = new PriorityQueue<>();
        HashSet<Long> seen = new HashSet<>();
        long[] primes = {2, 3, 5};
        
        heap.add(1L);
        seen.add(1L);
        
        long currentUgly = 1L;
        for (int i = 0; i < n; i++) {
            currentUgly = heap.poll();
            for (long prime : primes) {
                long newUgly = currentUgly * prime;
                if (!seen.contains(newUgly)) {
                    heap.add(newUgly);
                    seen.add(newUgly);
                }
            }
        }
        
        return (int) currentUgly;
    }
}