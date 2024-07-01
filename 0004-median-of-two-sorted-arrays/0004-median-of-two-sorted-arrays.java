class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        int[] arr = new int[n];
        int i=0, j =0, k =0;
        while(i<= nums1.length && j<=nums2.length){
            if(i == nums1.length){
                while(j<nums2.length) {
                    arr[k++] = nums2[j++];
                }
                break;
            }
            else if ( j == nums2.length){
                while(i<nums1.length){
                    arr[k++] = nums1[i++];
                }
                break;
            }
            if(nums1[i] < nums2[j]){
                arr[k++] = nums1[i++];
            }
            else{
                arr[k++] = nums2[j++];
            }
        }

        if(n%2==0){
            return (float) (arr[n/2-1] + arr[n/2])/2;
        }
        else{
            return arr[n/2];
        }
    }
}