
class Solution {
    public int longestConsecutive(int[] nums) {

        //we only need the length of the longest array
        HashSet<Integer> set = new HashSet<>();

        for(int num : nums){
            set.add(num);
        }
        int longest = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                int current = num;
                int count = 1;

                while(set.contains(current + 1)){
                current++;
                count++;
                }
                longest = Math.max(count,longest);
            }
          
        }
        
        return longest;
    }
}
