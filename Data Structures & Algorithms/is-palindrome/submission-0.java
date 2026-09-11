class Solution {
    public boolean isPalindrome(String s) {
        //covert to lowercase
        String str = s.toLowerCase();

        //remove all alpha numeric charcters
        //travse from front and back
        int i= 0;
        int j= str.length() -1;

        while(i < j) {
            //this is how pointers move towards each other

            if(!Character.isLetterOrDigit(str.charAt(i))){
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(str.charAt(j))){
                j--;
                continue;
            }

            if(str.charAt(i) != str.charAt(j)){
                    return false;
                    
            }
                i++;
                j--;
        }

            return true;

        }
        


        
        
    }
