import java.util.*;

class Solution {
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages); // Step 1: Sort the ages
        int n = ages.length;
        int totalRequests = 0;

        for (int i = 0; i < n; i++) {
            int ageX = ages[i];
            
            // Find the minimum valid age (ageY > 0.5 * ageX + 7)
            int minIndex = lowerBound(ages, 0.5 * ageX + 7);
            
            // Find the maximum valid age (ageY <= ageX)
            int maxIndex = upperBound(ages, ageX);
            
            // Count valid requests in the range [minIndex, maxIndex)
            if (maxIndex > minIndex) {
                totalRequests += maxIndex - minIndex - 1; // Exclude self-request
            }
        }

        return totalRequests;
    }

    private int lowerBound(int[] ages, double value) {
        int low = 0, high = ages.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (ages[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    private int upperBound(int[] ages, int value) {
        int low = 0, high = ages.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (ages[mid] > value) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
