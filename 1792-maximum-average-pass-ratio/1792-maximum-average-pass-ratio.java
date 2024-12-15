import java.util.PriorityQueue;

class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        // Max-Heap to store classes by maximum pass ratio improvement
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));

        // Initialize the heap with all classes
        for (int[] cls : classes) {
            int pass = cls[0];
            int total = cls[1];
            double improvement = improvement(pass, total);
            maxHeap.offer(new double[]{improvement, pass, total});
        }

        // Distribute the extra students
        for (int i = 0; i < extraStudents; i++) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            pass++;
            total++;
            maxHeap.offer(new double[]{improvement(pass, total), pass, total});
        }

        // Calculate the final average pass ratio
        double totalRatio = 0.0;
        while (!maxHeap.isEmpty()) {
            double[] top = maxHeap.poll();
            int pass = (int) top[1];
            int total = (int) top[2];
            totalRatio += (double) pass / total;
        }

        return totalRatio / classes.length;
    }

    // Helper function to calculate improvement in pass ratio
    private double improvement(int pass, int total) {
        return ((double) (pass + 1) / (total + 1)) - ((double) pass / total);
    }
}
