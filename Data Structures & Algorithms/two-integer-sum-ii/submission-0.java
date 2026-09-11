class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //given that array is sorted 
        //declare two pointer
        int left=0;
        int right = numbers.length - 1;

        while(left < right){
            int sum = numbers[left] + numbers[right];

            if(sum == target){
               // 1-indexed positions
                return new int[]{left+1,right+1};
            }
            if(sum < target){
                left++;
            }
            if(sum > target){
                right--;
            }
        }        
        return new int[]{-1,-1}; //fallback
    }
}
