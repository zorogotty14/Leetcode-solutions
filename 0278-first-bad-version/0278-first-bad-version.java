/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1, right = n;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid; // Narrow down the search to the left half
            } else {
                left = mid + 1; // Narrow down the search to the right half
            }
        }
        
        return left; // or right, since left == right
    }
}