import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final double TARGET = 24.0;
    private static final double EPSILON = 1e-6;

    public boolean judgePoint24(int[] cards) {
        List<Double> nums = new ArrayList<>();
        for (int card : cards) {
            nums.add((double) card);
        }
        return backtrack(nums);
    }

    private boolean backtrack(List<Double> nums) {
        // Base case: only one number left, check if it equals TARGET
        if (nums.size() == 1) {
            return Math.abs(nums.get(0) - TARGET) < EPSILON;
        }

        // Try every pair of numbers and every operation
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size(); j++) {
                if (i != j) {
                    List<Double> nextNums = new ArrayList<>();
                    // Choose two numbers to operate on, add remaining to nextNums
                    for (int k = 0; k < nums.size(); k++) {
                        if (k != i && k != j) {
                            nextNums.add(nums.get(k));
                        }
                    }

                    // Try each operation on nums[i] and nums[j]
                    for (double result : compute(nums.get(i), nums.get(j))) {
                        nextNums.add(result);
                        if (backtrack(nextNums)) {
                            return true;
                        }
                        nextNums.remove(nextNums.size() - 1);  // Undo last addition
                    }
                }
            }
        }
        return false;
    }

    private List<Double> compute(double a, double b) {
        List<Double> results = new ArrayList<>();
        results.add(a + b);  // Addition
        results.add(a - b);  // Subtraction (a - b)
        results.add(b - a);  // Subtraction (b - a)
        results.add(a * b);  // Multiplication
        if (Math.abs(b) > EPSILON) {
            results.add(a / b);  // Division (a / b)
        }
        if (Math.abs(a) > EPSILON) {
            results.add(b / a);  // Division (b / a)
        }
        return results;
    }
}
