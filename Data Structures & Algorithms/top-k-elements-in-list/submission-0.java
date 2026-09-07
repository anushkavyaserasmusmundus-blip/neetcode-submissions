class Solution {
    public int[] topKFrequent(int[] nums, int k) { //[1,1,1,2,2,3,4]
        
        //frequency count
        Map<Integer, Integer> map = new HashMap<>(); //1->3 2->2 3->1 4->1 
        for(int num : nums){ 
            map.put(num, map.getOrDefault(num,0) + 1);
        }//we go through each num in nums and put it into map


        List<Integer>[] buckets = new List[nums.length + 1]; 
        //frequency group  1->3 2->2 3,4->1

        for(int num : map.keySet()){
            int frequency = map.get(num);

            if(buckets[frequency] == null ){
                buckets[frequency] = new ArrayList<>();
            }

            buckets[frequency].add(num);
        }

        int [] result = new int[k];
        int index=0;

        //count from backwards untill k to get top elements
        for(int i = buckets.length -1 ; i >=0 && index < k ; i--){
            if(buckets[i] != null){
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
