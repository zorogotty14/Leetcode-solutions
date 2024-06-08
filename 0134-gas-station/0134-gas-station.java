class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int start = 0;
        int totalGas = 0;
        int currGas = 0;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            currGas += diff;
            totalGas += diff;

            if (currGas < 0) {
                start = i + 1;
                currGas = 0;
            }
        }

        return totalGas >= 0 ? start : -1;
    }
}