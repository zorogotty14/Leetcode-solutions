class MyCircularQueue {
    private int[] queue;  // Array to store queue elements
    private int head;      // Pointer to the front of the queue
    private int tail;      // Pointer to the rear of the queue
    private int size;      // Current number of elements in the queue
    private int capacity;  // Maximum capacity of the queue

    public MyCircularQueue(int k) {
        capacity = k;               // Set capacity to the given size
        queue = new int[k];          // Initialize the array to store elements
        head = -1;                   // Initialize head pointer
        tail = -1;                   // Initialize tail pointer
        size = 0;                    // Initialize size of the queue
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;  // If queue is full, insertion fails
        }
        if (isEmpty()) {
            head = 0;  // If queue was empty, reset head pointer to 0
        }
        tail = (tail + 1) % capacity;  // Update tail pointer circularly
        queue[tail] = value;           // Insert value at the new tail
        size++;                        // Increment size
        return true;                   // Successful insertion
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;  // If queue is empty, removal fails
        }
        if (head == tail) {
            // If there's only one element left, reset pointers to empty state
            head = -1;
            tail = -1;
        } else {
            head = (head + 1) % capacity;  // Move head pointer circularly
        }
        size--;  // Decrement size
        return true;  // Successful removal
    }

    public int Front() {
        return isEmpty() ? -1 : queue[head];  // Return front element or -1 if empty
    }

    public int Rear() {
        return isEmpty() ? -1 : queue[tail];  // Return rear element or -1 if empty
    }

    public boolean isEmpty() {
        return size == 0;  // Queue is empty if size is 0
    }

    public boolean isFull() {
        return size == capacity;  // Queue is full if size equals capacity
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
