class Solution {
    public String minWindow(String s, String t) {

        if(s.length() == 0 || t.length() == 0){
            return "";
        }

        //Hashmap for character frequency
        Map<Character, Integer> requiredMap = new HashMap<>();

        for(char ch : t.toCharArray()){
            requiredMap.put(ch, requiredMap.getOrDefault(ch, 0) + 1); 
            //return 0 for 1st occurence and adds +1 for next occurences
        }

        //initilise
        int left =0;
        int formed = 0; //freq of all required character untill now
        int required = requiredMap.size(); //size of the required map

        //formed should be = requied at the end

        int minLength = Integer.MAX_VALUE; //smallest valid window length
        int startIndex = 0; //start point of minLength

        //current window hashmap
        Map<Character, Integer> windowMap = new HashMap<>();

        for(int right =0; right < s.length(); right++){

            //char on right pointer
            char rightChar = s.charAt(right);

            windowMap.put(rightChar, windowMap.getOrDefault(rightChar, 0)+1);
            if(requiredMap.containsKey(rightChar) && windowMap.get(rightChar).intValue() == requiredMap.get(rightChar).intValue()){
                formed++;

            }

            //shrink the window while valid
            while(formed == required){

                int windowLength = right - left + 1; //counts the left between both the pointers

                //finding the smallest window
                if(windowLength < minLength){
                    minLength = windowLength;
                    startIndex = left; // save startindex at current left
                }

                //remove leftmost char
                char leftChar = s.charAt(left);

                //substract one left side
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);

                //check now if its valid again or not
                //if valid shortern more 

                //invalid condition
                if(requiredMap.containsKey(leftChar) && windowMap.get(leftChar) < requiredMap.get(leftChar)){
                    formed --;
                }
                //valid condition
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE){
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);


        
    }
}
//the sequence of characters dosent matter in this question only the occurence adn ferquency