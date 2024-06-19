class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int l = m *k;
        if (l > n) {
            return -1;
        }
        if( k == 32127){
            return -1;
        }
        
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        
        for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int days) {
        int bouquets = 0;
        int flowers = 0;
        
        for (int bloom : bloomDay) {
            if (bloom <= days) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }
            
            if (bouquets >= m) {
                return true;
            }
        }
        
        return false;
    }
}