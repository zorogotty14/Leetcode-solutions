class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;

        for (int i = low; i <= high; i++) {
            String s = Integer.toString(i);
            int len = s.length();

            // Only check numbers with even number of digits
            if (len % 2 != 0) continue;

            int mid = len / 2;
            int sum1 = 0, sum2 = 0;

            for (int j = 0; j < mid; j++) {
                sum1 += s.charAt(j) - '0';
            }
            for (int j = mid; j < len; j++) {
                sum2 += s.charAt(j) - '0';
            }

            if (sum1 == sum2) {
                count++;
            }
        }

        return count;
    }
}
