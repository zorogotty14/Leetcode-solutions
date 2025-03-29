import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;

    public int maximumScore(List<Integer> numsList, int k) {
        int n = numsList.size();
        int[] nums = numsList.stream().mapToInt(i -> i).toArray();

        // Step 1: Precompute prime scores
        int[] primeScores = new int[100001];
        for (int i = 2; i < primeScores.length; i++) {
            if (primeScores[i] == 0) {
                for (int j = i; j < primeScores.length; j += i) {
                    primeScores[j]++;
                }
            }
        }

        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = primeScores[nums[i]];
        }

        // Step 2: Monotonic Stack to find boundaries
        int[] left = new int[n];
        int[] right = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        // Left
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && score[stack.peek()] < score[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? i + 1 : i - stack.peek();
            stack.push(i);
        }

        stack.clear();
        // Right
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && score[stack.peek()] <= score[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n - i : stack.peek() - i;
            stack.push(i);
        }

        // Step 3: Create array of (value, count of subarrays it can be chosen)
        long[][] pairs = new long[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = (long) left[i] * right[i];
        }

        // Step 4: Sort by value descending
        Arrays.sort(pairs, (a, b) -> Long.compare(b[0], a[0]));

        // Step 5: Greedy multiplication
        long res = 1;
        for (int i = 0; i < n && k > 0; i++) {
            long use = Math.min(k, pairs[i][1]);
            res = modPow(res, 1, MOD) * modPow(pairs[i][0], use, MOD) % MOD;
            k -= use;
        }

        return (int) res;
    }

    long modPow(long base, long exp, int mod) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) res = res * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return res;
    }
}
