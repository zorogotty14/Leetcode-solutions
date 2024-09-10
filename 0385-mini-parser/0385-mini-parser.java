import java.util.Stack;

class Solution {
    public NestedInteger deserialize(String s) {
    if (s.isEmpty()) {
        return null;
    }
    
    // Special case: if the string doesn't represent a list but a single integer
    if (s.charAt(0) != '[') {
        return new NestedInteger(Integer.valueOf(s));
    }
    
    Stack<NestedInteger> stack = new Stack<>();
    NestedInteger curr = null;
    int l = 0; // Pointer for the start of a number substring
    
    for (int r = 0; r < s.length(); r++) {
        char ch = s.charAt(r);
        
        if (ch == '[') {
            // Start of a new NestedInteger list
            if (curr != null) {
                stack.push(curr);
            }
            curr = new NestedInteger(); // New list
            l = r + 1;
        } else if (ch == ']') {
            // If there's a number between the last comma or '[' and the current ']', add it
            if (r > l) {
                String num = s.substring(l, r).trim();
                if (!num.isEmpty()) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
            }
            // If there's something on the stack, pop it and add the current list to it
            if (!stack.isEmpty()) {
                NestedInteger pop = stack.pop();
                pop.add(curr);
                curr = pop;
            }
            l = r + 1;
        } else if (ch == ',') {
            // If a comma is found, we check if the previous substring is a number
            if (s.charAt(r - 1) != ']') {
                String num = s.substring(l, r).trim();
                if (!num.isEmpty()) {
                    curr.add(new NestedInteger(Integer.valueOf(num)));
                }
            }
            l = r + 1;
        }
    }
    
    return curr;
}

}
