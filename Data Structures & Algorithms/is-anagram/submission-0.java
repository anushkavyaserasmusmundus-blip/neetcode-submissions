class Solution {
    public boolean isAnagram(String s, String t) {

        int[] count = new int[26]; //because 26 alphabets

        if(s.length() != t.length()){
                return false;
            } //they are not anagram if they have diff lengths

        
        for(char c : s.toCharArray())
        {
           count[c - 'a']++;   
           //increment the cont of that position
            //example (3-0) -> (3) -> +1 3rd index   
        }
            //for t we will just decrement instead of incrementing
        for(char c : t.toCharArray()){
            count[c - 'a']--; 
            
        }

            //if each index has no values left its an anagram
        for(int n : count){
            if(n !=0){
                return false;
            }
            
        }

        return true;
    }
}
//in java each letter has a value for a its 0. so subtracting 'a' from each letter basically gives us that letter\position of that letter. Then we will simply increment the count with occurence.
