class Solution {
    public int[] findEvenNumbers(int[] digits) {
        // Count frequency of each digit (0-9)
        int[] frequency = new int[10];
        for (int digit : digits) {
            frequency[digit]++;
        }
        
        // Using a list to store results
        List<Integer> result = new ArrayList<>();
        
        // Iterate through all possible 3-digit numbers
        // First digit: 1-9 (no leading zeros)
        for (int i = 1; i <= 9; i++) {
            if (frequency[i] == 0) continue;
            
            // Decrement frequency for first digit
            frequency[i]--;
            
            // Second digit: 0-9
            for (int j = 0; j <= 9; j++) {
                if (frequency[j] == 0) continue;
                
                // Decrement frequency for second digit
                frequency[j]--;
                
                // Third digit: 0, 2, 4, 6, 8 (for even numbers)
                for (int k = 0; k <= 8; k += 2) {
                    if (frequency[k] == 0) continue;
                    
                    // Calculate the 3-digit number
                    int num = i * 100 + j * 10 + k;
                    result.add(num);
                }
                
                // Restore frequency for second digit
                frequency[j]++;
            }
            
            // Restore frequency for first digit
            frequency[i]++;
        }
        
        // Convert list to array
        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }
        
        return resultArray;
    }
}