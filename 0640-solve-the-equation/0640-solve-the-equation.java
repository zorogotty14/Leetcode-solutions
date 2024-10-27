class Solution {
    public String solveEquation(String equation) {
        // Split the equation into left and right sides using '='
        String[] parts = equation.split("=");
        int[] left = parseEquation(parts[0]);
        int[] right = parseEquation(parts[1]);

        // Combine the coefficients and constants from both sides
        int xCoeff = left[0] - right[0];  // Coefficient of 'x'
        int constant = right[1] - left[1];  // Constant value

        // Handle different cases
        if (xCoeff == 0) {
            if (constant == 0) {
                return "Infinite solutions";
            } else {
                return "No solution";
            }
        }

        // If one solution exists, return it
        int xValue = constant / xCoeff;
        return "x=" + xValue;
    }

    // Helper method to parse a part of the equation
    private int[] parseEquation(String expr) {
        int xCoeff = 0;  // Coefficient of 'x'
        int constant = 0;  // Constant value

        // Add a '+' in front if the expression does not start with a sign
        if (expr.charAt(0) != '+' && expr.charAt(0) != '-') {
            expr = "+" + expr;
        }

        // Parse the expression term by term
        int i = 0;
        while (i < expr.length()) {
            int j = i + 1;
            // Move j to the end of the current term
            while (j < expr.length() && expr.charAt(j) != '+' && expr.charAt(j) != '-') {
                j++;
            }

            // Extract the current term
            String term = expr.substring(i, j);
            if (term.contains("x")) {
                // Handle the coefficient of 'x'
                String coeff = term.replace("x", "");
                if (coeff.equals("+") || coeff.equals("")) {
                    xCoeff += 1;
                } else if (coeff.equals("-")) {
                    xCoeff -= 1;
                } else {
                    xCoeff += Integer.parseInt(coeff);
                }
            } else {
                // Handle the constant term
                constant += Integer.parseInt(term);
            }
            i = j;
        }
        return new int[]{xCoeff, constant};
    }
}
