import java.util.*;

class Solution {
    public int evaluate(String expression) {
        return evaluate(expression, new HashMap<>());
    }

    private int evaluate(String expression, Map<String, Deque<Integer>> scope) {
        if (expression.charAt(0) != '(') {
            // If the expression is a number
            if (Character.isDigit(expression.charAt(0)) || expression.charAt(0) == '-') {
                return Integer.parseInt(expression);
            }
            // If the expression is a variable, look it up in the scope
            return scope.get(expression).peek();
        }

        // Remove the outer parentheses
        String subExpression = expression.substring(1, expression.length() - 1);
        String[] tokens = tokenize(subExpression);
        String command = tokens[0];

        if ("let".equals(command)) {
            // let expression
            for (int i = 1; i < tokens.length - 1; i += 2) {
                String var = tokens[i];
                if (i + 1 < tokens.length - 1) {
                    int val = evaluate(tokens[i + 1], scope);
                    scope.putIfAbsent(var, new ArrayDeque<>());
                    scope.get(var).push(val);
                }
            }
            // Evaluate the final expression
            int result = evaluate(tokens[tokens.length - 1], scope);
            for (int i = 1; i < tokens.length - 1; i += 2) {
                String var = tokens[i];
                scope.get(var).pop();
                if (scope.get(var).isEmpty()) {
                    scope.remove(var);
                }
            }
            return result;
        } else if ("add".equals(command)) {
            // add expression
            return evaluate(tokens[1], scope) + evaluate(tokens[2], scope);
        } else if ("mult".equals(command)) {
            // mult expression
            return evaluate(tokens[1], scope) * evaluate(tokens[2], scope);
        }

        throw new IllegalArgumentException("Invalid expression");
    }

    private String[] tokenize(String expression) {
        List<String> tokens = new ArrayList<>();
        int balance = 0;
        StringBuilder token = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ' ') {
                if (balance == 0 && token.length() > 0) {
                    tokens.add(token.toString());
                    token.setLength(0);
                } else {
                    token.append(c);
                }
            } else if (c == '(') {
                balance++;
                token.append(c);
            } else if (c == ')') {
                balance--;
                token.append(c);
            } else {
                token.append(c);
            }
        }
        if (token.length() > 0) {
            tokens.add(token.toString());
        }
        return tokens.toArray(new String[0]);
    }
}
