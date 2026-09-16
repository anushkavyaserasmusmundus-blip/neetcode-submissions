class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        //piles- [3,6,7,11]
        //total hours to eat all (h) = 8
        //eating speed = 3 -> ate 3 bananas per hour
        //"How fast does Koko need to eat so that she can finish ALL the piles before her time runs out?"
       //If a speed takes more than h hours → speed is too slow → increase k.
       //If a speed takes h or fewer hours → speed works → try a smaller k.

       int left = 1;
       int right = 0;
        // right is the highest no in all piles
       for(int pile : piles){
        right = Math.max(right,pile);
       }

       while(left <= right){
        int k = (left+right)/2;
        int hours = 0;

        //hours needed for each pile at speed k
        for(int pile : piles){
            hours += (pile + k-1)/k ;
                    //7 + 3-1 / 3    9/3    = 3
                    /*for pile 7 at 3 banan per hours. 
                    7-3 =4 -> 1 hour
                    4-3=1 -> 1 hour
                    1=0   -> 1 hour   total 3 hours*/
        }
        

        if(hours <= h){
            right = k - 1; //that speed - 1
        }
        else{
            left = k + 1; //next speed
        }

       }




        return left;
        
    }
}
