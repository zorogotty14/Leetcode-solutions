class Solution {
    public int totalFruit(int[] fruits) {
        // Map to store counts of each fruit type in the current window
        Map<Integer, Integer> countMap = new HashMap<>();
        
        int left = 0;            // start index of the window
        int maxFruits = 0;       // result: the largest valid window size
        
        for (int right = 0; right < fruits.length; right++) {
            // Add the new fruit on the right into the map
            countMap.put(fruits[right], countMap.getOrDefault(fruits[right], 0) + 1);
            
            // If we have more than 2 distinct fruit types, shrink from the left
            while (countMap.size() > 2) {
                int leftFruit = fruits[left];
                countMap.put(leftFruit, countMap.get(leftFruit) - 1);
                if (countMap.get(leftFruit) == 0) {
                    countMap.remove(leftFruit);
                }
                left++;
            }
            
            // Now we have at most 2 distinct fruit types
            // Update the maximum window size
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
        
        return maxFruits;
    }
}
