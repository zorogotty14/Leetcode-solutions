class Solution {
    public boolean isSelfCrossing(int[] distance) {
        int n = distance.length;
        
        if (n < 4) return false;

        for (int i = 3; i < n; i++) {
            // Case 1: Current distance crosses the distance two steps before.
            if (distance[i] >= distance[i - 2] && distance[i - 1] <= distance[i - 3]) {
                return true;
            }
            
            // Case 2: Current distance crosses the distance four steps before.
            if (i >= 4 && distance[i - 1] == distance[i - 3] && distance[i] + distance[i - 4] >= distance[i - 2]) {
                return true;
            }
            
            // Case 3: Current distance crosses the distance six steps before.
            if (i >= 5 && distance[i - 2] >= distance[i - 4] && distance[i] + distance[i - 4] >= distance[i - 2] &&
                distance[i - 1] <= distance[i - 3] && distance[i - 1] + distance[i - 5] >= distance[i - 3]) {
                return true;
            }
        }
        
        return false;
    }
}
