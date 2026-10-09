class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        //declare deque
        Deque<Integer> dq = new ArrayDeque<>();

        int n = nums.length; //total count of numbers

        //resultant array
        int[] result = new int[n - k + 1];

        int index = 0; //index at resultant array

        for(int right = 0; right < n; right++){

            //cleanup steps for deque:

            //remove front that left the window 
            while(!dq.isEmpty() && dq.peekFirst() <= right - k){
                                    //top - left elem removed
                dq.pollFirst(); //removes and returns first element to only keep elements inside the window
            }

            //remove element that cant be max
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]){
                dq.pollLast();
            }

            dq.offerLast(right); //add current index to the back
            //store for later checks

            //checks if window is k size
            if(right >= k - 1){
                //take front of dq and store that value in our resut array 
                result[index++] = nums[dq.peekFirst()];
                                    //first is front of the deque

            }
        }

        return result;
        
    }
}

/*Deque- it is a type of queue that can add or remove elements from both the siedes*/
/*the approach for this is to use a deque. start with k elements in the dequqe, maintain a max and remove elements from left add from right and only compare the new element with the current max*/