class Solution {
    public int sumSubarrayMins(int[] arr) {
        // We'll compute contribution of each arr[i] 
        // using the "Previous Less Element" + "Next Less-or-Equal Element" technique.

        final int MOD = 1_000_000_007;
        int n = arr.length;

        // 1) Compute left[] array
        // left[i]: number of consecutive subarrays ending at i (to the left) for which arr[i] is the min
        // We'll find the index j of the "previous smaller element" so left[i] = i - j
        int[] left = new int[n];
        // stack will hold indices in strictly increasing order of arr[] 
        // so that we can pop until we find smaller.
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // pop while arr[stack.top()] >= arr[i]
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            // if stack is empty, no smaller element to the left
            left[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        // 2) Compute right[] array
        // right[i]: number of consecutive subarrays starting at i (to the right) for which arr[i] is the min
        // We find the "next smaller or equal element".
        int[] right = new int[n];
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            // pop while arr[stack.top()] > arr[i]  (strictly greater, so we break on "equal")
            // but for "sum of subarray minimum", we actually pop while arr[stack.top()] > arr[i]
            // to ensure if arr[stack.top()] == arr[i], it stops. 
            // Because we want "next smaller or equal" to break the subarray.
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? (n - i) : (stack.peek() - i);
            stack.push(i);
        }

        // 3) Sum up contributions: arr[i] * left[i] * right[i]
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long contribution = (long) arr[i] * left[i] * right[i];
            ans = (ans + contribution) % MOD;
        }

        return (int) ans;
    }
}
