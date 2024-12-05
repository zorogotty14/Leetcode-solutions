import java.util.*;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        
        // Step 1: Create Worker objects with ratio, quality, and wage
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker((double) wage[i] / quality[i], quality[i], wage[i]);
        }
        
        // Step 2: Sort workers by ratio in ascending order
        Arrays.sort(workers, Comparator.comparingDouble(w -> w.ratio));
        
        // Step 3: Use a max heap to maintain the group of k workers with the smallest total quality
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        
        for (Worker worker : workers) {
            maxHeap.add(worker.quality);
            totalQuality += worker.quality;
            
            // If the group size exceeds k, remove the worker with the largest quality
            if (maxHeap.size() > k) {
                totalQuality -= maxHeap.poll();
            }
            
            // If the group size is exactly k, calculate the cost
            if (maxHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * worker.ratio);
            }
        }
        
        return minCost;
    }
    
    private static class Worker {
        double ratio;
        int quality;
        int wage;
        
        Worker(double ratio, int quality, int wage) {
            this.ratio = ratio;
            this.quality = quality;
            this.wage = wage;
        }
    }
}
