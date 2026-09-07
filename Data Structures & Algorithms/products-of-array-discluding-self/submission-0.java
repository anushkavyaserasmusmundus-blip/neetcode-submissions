class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] output = new int[nums.length];

        int leftproduct =1;

        for(int i=0; i<nums.length; i++){
            output[i] = leftproduct;
            leftproduct *= nums[i];
        }


        int rightproduct =1;

        for(int i=nums.length - 1; i>=0; i--){
            output[i] *= rightproduct;
            rightproduct *= nums[i];
        }
        return output;
    }
    
}  
