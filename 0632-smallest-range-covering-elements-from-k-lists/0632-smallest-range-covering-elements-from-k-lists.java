import java.util.List;
import java.util.PriorityQueue;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap to keep track of the minimum element
        PriorityQueue<Element> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);
        
        int currentMax = Integer.MIN_VALUE;
        int rangeStart = 0, rangeEnd = Integer.MAX_VALUE;

        // Insert the first element of each list into the heap
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new Element(value, i, 0));
            currentMax = Math.max(currentMax, value);
        }

        // Process the heap until we exhaust one of the lists
        while (minHeap.size() == nums.size()) {
            Element minElement = minHeap.poll();
            int currentMin = minElement.value;
            
            // Check if the current range [currentMin, currentMax] is smaller
            if (currentMax - currentMin < rangeEnd - rangeStart) {
                rangeStart = currentMin;
                rangeEnd = currentMax;
            }
            
            // Move to the next element in the list from which the current min was taken
            if (minElement.idx + 1 < nums.get(minElement.row).size()) {
                int nextValue = nums.get(minElement.row).get(minElement.idx + 1);
                minHeap.offer(new Element(nextValue, minElement.row, minElement.idx + 1));
                currentMax = Math.max(currentMax, nextValue);
            } else {
                // If we run out of elements in any list, we can't process further
                break;
            }
        }
        
        return new int[] {rangeStart, rangeEnd};
    }
}

// Helper class to store the elements along with row and index in the row
class Element {
    int value;
    int row;
    int idx;

    Element(int value, int row, int idx) {
        this.value = value;
        this.row = row;
        this.idx = idx;
    }
}
