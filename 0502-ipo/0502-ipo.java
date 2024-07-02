class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-Heap for projects based on capital required
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max-Heap for projects based on profit
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int n = profits.length;

        // Populate the Min-Heap with all projects
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { capital[i], profits[i] });
        }

        // Pick up to k projects
        for (int i = 0; i < k; i++) {
            // Move all affordable projects to the Max-Heap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll());
            }

            // If no projects can be done, break
            if (maxHeap.isEmpty()) {
                break;
            }

            // Select the project with the highest profit
            w += maxHeap.poll()[1];
        }

        return w;
    }
}