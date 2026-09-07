class Solution {
    public int[] topKFrequent(int[] nums, int k) { //[1,1,1,2,2,3,4]
        
        //frequency count                            
        Map<Integer, Integer> map = new HashMap<>(); 
        // number-> frequency
        //{1=3, 2=2, 3=1, 4=1}

        for(int num : nums){ 
            map.put(num, map.getOrDefault(num,0) + 1);
        }//we go through each num in nums and put it into map


        List<Integer>[] buckets = new List[nums.length + 1]; 
        //The index of the bucket represents frequency.
        //bucket[1] → numbers appearing 1 time
        //bucket[2] → numbers appearing 2 times

       // bucket[1] → [3, 4]
       // bucket[2] → [2]
      //  bucket[3] → [1]

        for(int num : map.keySet()){
            int frequency = map.get(num); //for 1 we get freq = 3

            if(buckets[frequency] == null ){ 
                buckets[frequency] = new ArrayList<>();
            }
            //if there is np bucker for 3  create bucket
            buckets[frequency].add(num);
            //f there is a bucker for 3 add
        }

        int [] result = new int[k]; //resultant array
        int index=0; //This tells us where we're going to insert the next answer.

        //count from backwards untill k to get top elements
        for(int i = buckets.length -1 ; i >=0 && index < k ; i--){
            if(buckets[i] != null){ //1st iteration i=7 bucket=null 
                for(int num : buckets[i]){
                    result[index] = num;
                    index++;

                    if(index == k){
                        break;
                    }
                }
            }

        }


        return result;

    }
}
