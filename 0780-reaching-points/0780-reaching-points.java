class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        // Work backwards until tx < sx or ty < sy
        while (tx >= sx && ty >= sy) {
            if (tx == sx && ty == sy) {
                return true;
            }
            if (tx > ty) {
                if (ty > sy) {
                    tx %= ty; // Reduce tx by the largest possible steps
                } else {
                    // Special case: when ty == sy, check if (tx - sx) is divisible by ty
                    return (tx - sx) % ty == 0;
                }
            } else {
                if (tx > sx) {
                    ty %= tx; // Reduce ty by the largest possible steps
                } else {
                    // Special case: when tx == sx, check if (ty - sy) is divisible by tx
                    return (ty - sy) % tx == 0;
                }
            }
        }
        return false;
    }
}
