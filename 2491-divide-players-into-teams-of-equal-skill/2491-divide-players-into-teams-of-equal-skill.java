import java.util.Arrays;

class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        int targetSum = skill[0] + skill[n - 1]; // Target team skill sum
        long totalChemistry = 0;
        
        for (int i = 0; i < n / 2; i++) {
            int currentPairSum = skill[i] + skill[n - 1 - i];
            if (currentPairSum != targetSum) {
                return -1; // No valid division possible
            }
            totalChemistry += (long) skill[i] * skill[n - 1 - i]; // Calculate chemistry
        }
        
        return totalChemistry;
    }
}
