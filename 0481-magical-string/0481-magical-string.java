class Solution {
    public int magicalString(int n) {
        if (n <= 0) return 0;
        if (n <= 3) return 1;  // "122" contains only one '1'

        // Initialize the magical string with the first three characters
        int[] magicalString = new int[n + 1];
        magicalString[0] = 1;
        magicalString[1] = 2;
        magicalString[2] = 2;

        int numOfOnes = 1; // We already have one '1'
        int head = 2;      // Pointer to where we are in the magical string (to decide how many 1's or 2's to add)
        int tail = 3;      // Pointer to the next position to fill in the magical string
        int nextNum = 1;   // The next number to add (either 1 or 2)

        while (tail < n) {
            for (int i = 0; i < magicalString[head]; i++) {
                magicalString[tail] = nextNum;
                if (nextNum == 1 && tail < n) {
                    numOfOnes++; // Increment the count of 1's if we add a 1
                }
                tail++;
                if (tail >= n) break; // Stop once we've filled up to n characters
            }
            nextNum = nextNum == 1 ? 2 : 1; // Toggle between adding 1's and 2's
            head++;
        }

        return numOfOnes;
    }
}
