class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if (target.length != arr.length) {
            return false;
        }
        
        Map<Integer, Integer> targetCount = new HashMap<>();
        Map<Integer, Integer> arrCount = new HashMap<>();
        
        for (int num : target) {
            targetCount.put(num, targetCount.getOrDefault(num, 0) + 1);
        }
        
        for (int num : arr) {
            arrCount.put(num, arrCount.getOrDefault(num, 0) + 1);
        }
        
        return targetCount.equals(arrCount);
    }
}