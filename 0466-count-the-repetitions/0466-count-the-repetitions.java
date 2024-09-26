import java.util.HashMap;
import java.util.Map;

class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) return 0;
        
        int len1 = s1.length(), len2 = s2.length();
        int count1 = 0, count2 = 0, index2 = 0;
        
        Map<Integer, int[]> memo = new HashMap<>();
        
        while (count1 < n1) {
            for (int i = 0; i < len1; i++) {
                if (s1.charAt(i) == s2.charAt(index2)) {
                    index2++;
                    if (index2 == len2) {
                        count2++;
                        index2 = 0;
                    }
                }
            }
            count1++;
            
            if (memo.containsKey(index2)) {
                int[] prev = memo.get(index2);
                int prevCount1 = prev[0], prevCount2 = prev[1];
                
                int cycleLength = count1 - prevCount1;
                int cycleCount2 = count2 - prevCount2;
                
                int remainingCycles = (n1 - count1) / cycleLength;
                
                count1 += remainingCycles * cycleLength;
                count2 += remainingCycles * cycleCount2;
            } else {
                memo.put(index2, new int[]{count1, count2});
            }
        }
        
        return count2 / n2;
    }
}
