class Solution {
    public String getPermutation(int n, int k) {
        // Create a list of numbers to get indices
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Create an array to store factorial values
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Adjust k to be zero-indexed
        k--;

        // Build the k-th permutation
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int idx = k / factorial[i - 1];
            result.append(numbers.get(idx));
            numbers.remove(idx);
            k %= factorial[i - 1];
        }

        return result.toString();
    }
}