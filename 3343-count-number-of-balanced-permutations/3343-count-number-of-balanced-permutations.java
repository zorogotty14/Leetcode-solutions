class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] fact, inv, invFact;
    
    private void precompute(int n) {
        fact = new long[n + 1];
        inv = new long[n + 1];
        invFact = new long[n + 1];
        
        // Calculate factorials
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        
        // Calculate modular inverses
        inv[1] = 1;
        for (int i = 2; i <= n; i++) {
            inv[i] = MOD - (MOD / i) * inv[MOD % i] % MOD;
        }
        
        // Calculate inverse factorials
        invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            invFact[i] = (invFact[i - 1] * inv[i]) % MOD;
        }
    }
    
    public int countBalancedPermutations(String s) {
        int n = s.length();
        int sum = 0;
        
        // Calculate total sum of digits
        for (int i = 0; i < n; i++) {
            sum += s.charAt(i) - '0';
        }
        
        // If sum is odd, balanced permutation is impossible
        if (sum % 2 == 1) {
            return 0;
        }
        
        // Precompute factorials and their modular inverses
        precompute(n);
        
        int halfSum = sum / 2;
        int halfLen = n / 2;
        
        // dp[i][j] = number of ways to select j positions with sum i
        int[][] dp = new int[halfSum + 1][halfLen + 1];
        dp[0][0] = 1;
        
        // Count occurrences of each digit
        int[] digits = new int[10];
        for (int i = 0; i < n; i++) {
            digits[s.charAt(i) - '0']++;
        }
        
        // Fill dp table
        for (int d = 0; d <= 9; d++) {
            for (int count = 1; count <= digits[d]; count++) {
                for (int i = halfSum; i >= d; i--) {
                    for (int j = halfLen; j >= 1; j--) {
                        if (i >= d && j >= 1) {
                            dp[i][j] = (dp[i][j] + dp[i - d][j - 1]) % MOD;
                        }
                    }
                }
            }
        }
        
        // Calculate final result
        long res = dp[halfSum][halfLen];
        res = (res * fact[halfLen]) % MOD;
        res = (res * fact[n - halfLen]) % MOD;
        
        // Divide by factorials of repeated digit counts
        for (int i = 0; i < 10; i++) {
            if (digits[i] > 0) {
                res = (res * invFact[digits[i]]) % MOD;
            }
        }
        
        return (int) res;
    }
}