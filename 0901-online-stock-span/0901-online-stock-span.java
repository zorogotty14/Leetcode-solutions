import java.util.Stack;

class StockSpanner {
    private Stack<int[]> stack; // Stack to store pairs of {price, span}

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        // Merge spans for all previous prices less than or equal to the current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push the current price and its calculated span onto the stack
        stack.push(new int[]{price, span});
        return span;
    }
}
