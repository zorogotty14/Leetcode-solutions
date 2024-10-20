class Solution {
    public boolean parseBoolExpr(String expression) {
        return evaluate(expression, 0, expression.length() - 1);
    }

    // Helper function to evaluate the expression recursively
    private boolean evaluate(String expr, int start, int end) {
        char operator = expr.charAt(start);
        
        if (operator == 't') return true;
        if (operator == 'f') return false;

        if (operator == '!') {
            // Negate the inner expression within parentheses
            return !evaluate(expr, start + 2, end - 1);
        }

        boolean result = (operator == '&');  // Assume true for AND, false for OR
        int i = start + 2;  // Skip the operator and the opening '('

        while (i < end) {
            int nextCommaOrClosing = findNextCommaOrClosing(expr, i);
            boolean subExprResult = evaluate(expr, i, nextCommaOrClosing - 1);

            if (operator == '&') result = result && subExprResult;
            else if (operator == '|') result = result || subExprResult;

            // Break early for OR if result is true, or for AND if result is false
            if ((operator == '|' && result) || (operator == '&' && !result)) break;

            i = nextCommaOrClosing + 1;  // Move to the next sub-expression
        }
        return result;
    }

    // Helper to find the next comma or closing parenthesis
    private int findNextCommaOrClosing(String expr, int start) {
        int depth = 0;
        for (int i = start; i < expr.length(); i++) {
            if (expr.charAt(i) == '(') depth++;
            else if (expr.charAt(i) == ')') depth--;
            else if (expr.charAt(i) == ',' && depth == 0) return i;
            if (depth < 0) return i;
        }
        return expr.length();
    }
}
