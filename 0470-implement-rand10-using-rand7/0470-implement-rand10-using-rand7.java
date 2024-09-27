class Solution extends SolBase {
    public int rand10() {
        int result;
        do {
            int row = rand7();
            int col = rand7();
            result = (row - 1) * 7 + col; // This will give a value between 1 and 49
        } while (result > 40); // Discard any result greater than 40
        
        return (result - 1) % 10 + 1; // Map result to 1-10
    }
}
