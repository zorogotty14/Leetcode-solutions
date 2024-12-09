import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        Map<String, Integer> dp = new HashMap<>();
        int maxLength = 0;

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                int iValue = arr[k] - arr[j];
                if (iValue < arr[j] && indexMap.containsKey(iValue)) {
                    int i = indexMap.get(iValue);
                    String key = i + "," + j;
                    dp.put(j + "," + k, dp.getOrDefault(key, 2) + 1);
                    maxLength = Math.max(maxLength, dp.get(j + "," + k));
                } else {
                    dp.put(j + "," + k, 2);
                }
            }
        }

        return maxLength >= 3 ? maxLength : 0;
    }
}
