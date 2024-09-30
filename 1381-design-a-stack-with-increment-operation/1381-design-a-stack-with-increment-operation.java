class CustomStack {

    private int[] stack;
    private int[] incrementStack;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.incrementStack = new int[maxSize];
        this.maxSize = maxSize;
        this.top = -1; // Indicates the top of the stack
    }
    
    public void push(int x) {
        if (top < maxSize - 1) {
            top++;
            stack[top] = x;
        }
    }
    
    public int pop() {
        if (top == -1) {
            return -1;
        }
        int res = stack[top] + incrementStack[top];
        if (top > 0) {
            incrementStack[top - 1] += incrementStack[top];
        }
        incrementStack[top] = 0; // Reset increment after applying it
        top--;
        return res;
    }
    
    public void increment(int k, int val) {
        int limit = Math.min(k, top + 1) - 1;
        if (limit >= 0) {
            incrementStack[limit] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k, val);
 */
