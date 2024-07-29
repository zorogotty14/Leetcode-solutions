class Solution {
    public int numTeams(int[] rating) {
        int n = rating.length;
        if (n < 3) {
            return 0;
        }

        int count = 0;

        for (int j = 1; j < n - 1; j++) {
            int leftLess = 0, leftGreater = 0;
            int rightLess = 0, rightGreater = 0;

            // Count soldiers to the left of j
            for (int i = 0; i < j; i++) {
                if (rating[i] < rating[j]) {
                    leftLess++;
                } else if (rating[i] > rating[j]) {
                    leftGreater++;
                }
            }

            // Count soldiers to the right of j
            for (int k = j + 1; k < n; k++) {
                if (rating[k] < rating[j]) {
                    rightLess++;
                } else if (rating[k] > rating[j]) {
                    rightGreater++;
                }
            }

            // Calculate the number of valid teams with soldier j in the middle
            count += leftLess * rightGreater + leftGreater * rightLess;
        }

        return count;
    }
}