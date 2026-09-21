class Solution {
    public boolean checkInclusion(String s1, String s2) {
        /*s1 = "ab"
          s2 = "eidbaooo"*/

          //fixed size window sliding + char freq array

        //If s1 is longer than s2, there is no possible way for s2 to contain a permutation of s1.
          if(s1.length() > s2.length()){
            return false;
          }

        //frequency array
          int[] count1 = new int[26];
          int[] count2 = new int[26];

          //count charac in s1
          for(char c : s1.toCharArray()){
            count1[c - 'a']++; //increment the position in count array for that character
          }

        //create the first window as big as s1.length
          for(int i =0; i < s1.length(); i++){
            count2[s2.charAt(i) - 'a']++;
          }
        //match 2 from s1 to 2 from s2
          if(matches(count1, count2)){
            return true;
          }
          

        //sliding window stars
          for (int right = s1.length(); right < s2.length(); right++){  
            //add char on right side
            count2[s2.charAt(right) - 'a']++;

            //remove char on left side from window
            int left = right - s1.length(); // window size
            count2[s2.charAt(left) - 'a']--;//remove from count array

            if(matches(count1, count2)){
                return true;
            }
          }

        return false;
    }
    private boolean matches(int[] count1, int[] count2){
        for(int i =0; i < 26; i++){
            if(count1[i] != count2[i]){
                return false;
            }
            
        }
        return true;
    }
          
}
