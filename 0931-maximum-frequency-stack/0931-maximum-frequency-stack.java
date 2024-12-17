import java.util.*;

class FreqStack {

    private Map<Integer, Integer> freq; // Frequency map
    private Map<Integer, Stack<Integer>> group; // Map of frequency to elements stack
    private int maxFrequency; // Maximum frequency seen so far

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFrequency = 0;
    }
    
    public void push(int val) {
        // Increment the frequency of the value
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        
        // Update maxFrequency if needed
        maxFrequency = Math.max(maxFrequency, f);
        
        // Add the value to the group of its frequency
        group.computeIfAbsent(f, k -> new Stack<>()).push(val);
    }
    
    public int pop() {
        // Retrieve the most frequent element
        Stack<Integer> stack = group.get(maxFrequency);
        int val = stack.pop();
        
        // Decrement the frequency of the element
        freq.put(val, freq.get(val) - 1);
        
        // If the current max frequency stack is empty, reduce maxFrequency
        if (stack.isEmpty()) {
            maxFrequency--;
        }
        
        return val;
    }
}
