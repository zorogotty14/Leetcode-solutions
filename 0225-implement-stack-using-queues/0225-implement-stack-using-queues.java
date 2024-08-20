import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    // Push element x onto stack.
    public void push(int x) {
        q1.add(x);
    }
    
    // Removes the element on top of the stack and returns that element.
    public int pop() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        // The last element of q1 is the top element of the stack
        int topElement = q1.remove();
        
        // Swap q1 and q2 so that q1 is always the main queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return topElement;
    }
    
    // Get the top element.
    public int top() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        // The last element of q1 is the top element of the stack
        int topElement = q1.peek();
        // Move this element to q2
        q2.add(q1.remove());
        
        // Swap q1 and q2 so that q1 is always the main queue
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        
        return topElement;
    }
    
    // Returns whether the stack is empty.
    public boolean empty() {
        return q1.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */