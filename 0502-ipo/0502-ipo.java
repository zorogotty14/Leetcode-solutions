class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // Min-Heap based on capital
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // Max-Heap based on profits
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        int n = profits.length;

        // Initialize the Min-Heap with all projects
        for (int i = 0; i < n; i++) {
            minHeap.offer(new int[] { capital[i], profits[i] });
        }

        // Iterate up to k times to pick projects
        for (int i = 0; i < k; i++) {
            // Move all projects that can be started with the current capital to the Max-Heap
            while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                maxHeap.offer(minHeap.poll());
            }

            // If the Max-Heap is empty, we cannot start any more projects
            if (maxHeap.isEmpty()) {
                break;
            }

            // Start the project with the highest profit
            w += maxHeap.poll()[1];
        }

        return w;
    }
}