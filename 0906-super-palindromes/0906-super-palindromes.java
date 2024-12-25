class Solution {

    public int superpalindromesInRange(String left, String right) {
        long L = Long.parseLong(left);
        long R = Long.parseLong(right);
        
        // Generate all super-palindromes up to 10^18 (by generating palindromic roots up to 10^9).
        // We'll store them in a list.
        // Then we count how many lie within [L, R].
        
        // 1) Generate palindrome roots up to 10^9
        // 2) Square them, check if the result is palindrome
        // 3) Keep them if <= 10^18
        // 4) Count how many lie in [L, R]
        
        // We'll just build them and count on the fly.
        
        int count = 0;
        
        // For convenience, we'll have an upper limit for the root: up to 1_000_000_000 (10^9).
        // But we won't generate all integers up to 10^9. We'll only generate palindromes via a "half" construction approach.
        
        // We can generate palindromes in two categories:
        //  - odd length (center digit in the middle)
        //  - even length (mirror directly)
        
        // We'll define a function "generatePalindromes" that yields palindromes up to 10^9 as longs.
        // Then for each palindrome p, compute p^2. If p^2 <= 10^18 and is palindrome, check range.
        
        // The largest palindrome root we might need is just below 10^9, because (10^9)^2 = 10^18.
        
        // We'll do a loop for "half" from 1..99999 (since half can create up to 9-digit palindromes).
        // Why 99999? Because the half "99999" can generate a 10-digit palindrome close to 10^9 in magnitude. 
        // Actually, 99999 mirrored could be up to 9999999999 which is beyond 10^9, so we'll do checks carefully.
        
        // We'll store the resulting squares so we can sort them. Alternatively, we can check range on the fly.
        
        // A small list to hold super-palindromes (they might not be too many).
        List<Long> superPalList = new ArrayList<>();
        
        // Even length palindromes:
        for (int half = 1; half <= 100000; half++) {
            String s = String.valueOf(half);
            // mirror it to form even length, e.g. half="123" -> "123" + "321" = "123321"
            String rs = new StringBuilder(s).reverse().toString();
            String palStr = s + rs; // even-length palindrome
            long pal = Long.parseLong(palStr);
            if (pal > 1000000000L) {
                break;  // beyond 10^9
            }
            long square = pal * pal;
            if (square > 1000000000000000000L) { 
                break;  // beyond 10^18
            }
            if (isPalindrome(square)) {
                superPalList.add(square);
            }
        }
        
        // Odd length palindromes:
        for (int half = 1; half <= 100000; half++) {
            String s = String.valueOf(half);
            // For odd-length, we skip the last character of the reversed half when mirroring
            // e.g. half="123" -> "123" + "21" = "12321"
            String rs = new StringBuilder(s).reverse().toString();
            // omit the last digit from the reversed half
            String palStr = s + rs.substring(1); 
            long pal = Long.parseLong(palStr);
            if (pal > 1000000000L) {
                break;  // beyond 10^9
            }
            long square = pal * pal;
            if (square > 1000000000000000000L) {
                break;
            }
            if (isPalindrome(square)) {
                superPalList.add(square);
            }
        }
        
        // Now we have a list of all super-palindromes up to 10^18
        // Sort them
        Collections.sort(superPalList);
        
        // Count how many are in the range [L, R]
        int ans = 0;
        for (long val : superPalList) {
            if (val >= L && val <= R) {
                ans++;
            }
        }
        return ans;
    }
    
    // Helper: check if a long is palindrome by converting to string
    private boolean isPalindrome(long x) {
        String s = String.valueOf(x);
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
