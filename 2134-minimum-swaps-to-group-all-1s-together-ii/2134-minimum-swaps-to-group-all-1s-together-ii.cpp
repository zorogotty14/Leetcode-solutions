class Solution {
public:
     int minSwaps(vector<int>& nums) {
       int n = nums.size();
        int totalOnes = 0;

        // Count total number of 1s in the array
        for (int num : nums) {
            if (num == 1) {
                totalOnes++;
            }
        }

        // If there are no 1s or all elements are 1s, no swaps are needed
        if (totalOnes == 0 || totalOnes == n) {
            return 0;
        }

        // Extend the array to handle circular nature
        std::vector<int> extendedArray(2 * n);
        std::copy(nums.begin(), nums.end(), extendedArray.begin());
        std::copy(nums.begin(), nums.end(), extendedArray.begin() + n);

        // Initialize the sliding window
        int currentWindowOnes = 0;
        for (int i = 0; i < totalOnes; i++) {
            if (extendedArray[i] == 1) {
                currentWindowOnes++;
            }
        }

        int maxOnesInWindow = currentWindowOnes;

        // Slide the window across the extended array
        for (int i = totalOnes; i < 2 * n; i++) {
            if (extendedArray[i] == 1) {
                currentWindowOnes++;
            }
            if (extendedArray[i - totalOnes] == 1) {
                currentWindowOnes--;
            }
            maxOnesInWindow = std::max(maxOnesInWindow, currentWindowOnes);
        }

        // The minimum swaps needed is the total number of 1s minus the maximum number of 1s in any window
        return totalOnes - maxOnesInWindow;
    }
};
