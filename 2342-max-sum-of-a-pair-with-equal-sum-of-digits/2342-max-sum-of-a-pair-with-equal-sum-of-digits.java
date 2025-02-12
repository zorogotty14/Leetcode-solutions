import java.util.*;

class Solution {
    public int maximumSum(int[] nums) {
        // Map to store the maximum two numbers for each sum of digits
        Map<Integer, int[]> digitSumMap = new HashMap<>();
        int maxSum = -1;

        for (int num : nums) {
            int digitSum = getDigitSum(num);

            // If this digit sum is not yet in the map, initialize with two smallest values
            digitSumMap.putIfAbsent(digitSum, new int[]{-1, -1});

            int[] maxNums = digitSumMap.get(digitSum);

            // Update the two largest numbers for this digit sum
            if (num > maxNums[0]) {
                maxNums[1] = maxNums[0];
                maxNums[0] = num;
            } else if (num > maxNums[1]) {
                maxNums[1] = num;
            }

            // If we have two valid numbers, update the max sum
            if (maxNums[1] != -1) {
                maxSum = Math.max(maxSum, maxNums[0] + maxNums[1]);
            }
        }

        return maxSum;
    }

    // Helper method to calculate the sum of digits of a number
    private int getDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
