class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        long sumN = (long) n * (n + 1) / 2;
        long sumNSquares = (long) n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0, actualSumSquares = 0;
        for (int num : nums) {
            actualSum += num;
            actualSumSquares += (long) num * num;
        }

        // Let x be the missing number and y be the duplicate number.
        long diff = sumN - actualSum; // x - y
        long squareDiff = sumNSquares - actualSumSquares; // x^2 - y^2

        // From x^2 - y^2 = (x - y) * (x + y)
        long sum = squareDiff / diff; // x + y

        // Now solve for x and y using:
        // x - y = diff
        // x + y = sum
        int missing = (int) (diff + sum) / 2;
        int duplicate = (int) (sum - missing);

        return new int[]{duplicate, missing};
    }
}
