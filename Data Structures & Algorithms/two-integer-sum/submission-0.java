class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int compliment = target - nums[i];

            if(map.containsKey(compliment)){
                return new int [] {map.get(compliment) , i};
            }
            map.put(nums[i],i); // if its not present store the value and index no
        }

        return new int[] {}; // if you dont get anything return empty array
        
    }
}
