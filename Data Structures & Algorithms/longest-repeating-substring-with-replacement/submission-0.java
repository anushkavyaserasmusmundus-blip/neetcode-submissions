class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int left =0;
        int maxCount = 0; //same char count
        int best = 0;
        
        //xyyyx
        for(int right = 0; right < s.length(); right++){
            int index = s.charAt(right) - 'A';
            //numeric position of char - A=0 -> char position
            count[index]++;

            //maxcount will keep the char that occurs most
            maxCount = Math.max(maxCount, count[index]);
            //max times a particular char is repeated
            int windowSize = right - left + 1;

            if(windowSize - maxCount > k){ 
                //remaning unsimilar character
                count[s.charAt(left) - 'A']--;//remove char
                left++;//shrink window

            }

            best = Math.max(best, right - left + 1);
        }
        return best;
        
    }
}
/*we are given  avalue for k we have to tell what is the longest string we can create while having the liberty to only make k amount of changes*/
