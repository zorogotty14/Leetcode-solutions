class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;

        int baseSatisfied = 0;
        for (int i = 0; i < n; i++) {
            if (grumpy[i] == 0) {
                baseSatisfied += customers[i];
            }
        }

        int currentGain = 0;
        for (int i = 0; i < minutes; i++) {
            if (grumpy[i] == 1) {
                currentGain += customers[i];
            }
        }
        int maxGain = currentGain;

        for (int i = minutes; i < n; i++) {
            if (grumpy[i - minutes] == 1) {
                currentGain -= customers[i - minutes];
            }

            if (grumpy[i] == 1) {
                currentGain += customers[i];
            }

            maxGain = Math.max(maxGain, currentGain);
        }

        return baseSatisfied + maxGain;
    }
}