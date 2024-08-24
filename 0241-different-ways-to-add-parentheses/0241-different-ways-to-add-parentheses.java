import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            
            if (c == '+' || c == '-' || c == '*') {
                // Divide the expression into two parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                // Recursively compute the results for both parts
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                
                // Combine the results from both parts using the current operator
                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        int computedValue = 0;
                        if (c == '+') {
                            computedValue = leftResult + rightResult;
                        } else if (c == '-') {
                            computedValue = leftResult - rightResult;
                        } else if (c == '*') {
                            computedValue = leftResult * rightResult;
                        }
                        result.add(computedValue);
                    }
                }
            }
        }
        
        // Base case: if the expression contains only a number, return it as the only result
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        return result;
    }
}
