class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> set = new HashSet<>();
        //hashsets dosent allow duplicates

        int left =0; //start of window
        int maxLength = 0; //stores answer

        for(int right=0; right< s.length() ;right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;

            }
            set.add(s.charAt(right));

            int currentLength = right - left + 1; //+1 because of 0 indexing
            maxLength = Math.max(maxLength, currentLength);
        }



        

        
        return maxLength;
        
    }
}
