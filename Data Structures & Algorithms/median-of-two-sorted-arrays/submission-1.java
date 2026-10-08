class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //[1,3]  [2,4,5,6]
        //pick smaller array
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2,nums1); //swap array
        }
        int m = nums1.length;
        int n = nums2.length;

        int low = 0; //left wall
        int high = m; //right wall - as big as smallest array size

        //binary search
        while(low <= high){
            int i = (low + high) /2; //cut position nums1
            int j = (m+n+1) / 2 - i; //corresponding cut in nums2

            //borderline cases safety check for leftest/righest elements
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i-1];// cut left index
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i]; //cuts right index

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if(left1 <= right2 && left2 <= right1){
                //for correct partition
                if((m+n) % 2 == 1){
                    return Math.max(left1,left2); //odd
                }
                //even
                return (Math.max(left1,left2)+ Math.min(right1,right2)) / 2.0;
            }
                //partition incorrect
            else if (left1 > right2){
                    high = i - 1; //shift leftwards the right wall
            }
            else{
                    low = i + 1; //shift rightwards the low wall
            }

            
            


        }
        
       return 0.0; 
    }
}
