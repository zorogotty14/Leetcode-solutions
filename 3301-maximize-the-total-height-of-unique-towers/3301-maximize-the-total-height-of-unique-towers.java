class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        long x =0;
        Arrays.sort(maximumHeight);
        long curHeight = Integer.MAX_VALUE;
        for(int i = maximumHeight.length - 1 ; i >= 0;i--){
            curHeight = Math.min(curHeight, maximumHeight[i]);
            if(curHeight <= 0){
                return -1;
            }
            x += curHeight;
            curHeight--;
        }
        return x;
    }
}