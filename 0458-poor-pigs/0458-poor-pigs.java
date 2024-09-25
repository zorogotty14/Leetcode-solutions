class Solution {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        // Calculate the number of tests we can run
        int tests = minutesToTest / minutesToDie;
        
        // Initialize the number of pigs
        int pigs = 0;
        
        // Calculate the minimum number of pigs needed
        while (Math.pow(tests + 1, pigs) < buckets) {
            pigs++;
        }
        
        return pigs;
    }
}
