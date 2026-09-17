class TimeMap {

    class Pair{
        String value;
        int timestamp;
        //pair class - pair is an object that will store both values now and they will travel together
        Pair(String value, int timestamp){
            this.value= value;
            this.timestamp = timestamp;
        }
    }
    //declaration an empty hashmap
    HashMap<String, ArrayList<Pair>> map;

    public TimeMap() { //constructor
        //initialization
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {//store things
    if(!map.containsKey(key)){
        map.put(key, new ArrayList<>());
    }

    map.get(key).add(new Pair(value, timestamp));
    //requested key 
    //key -> hashmap
    //value pair -> arraylist

        
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }

        ArrayList<Pair> list = map.get(key);
        //retrieves list of pair stores for particular key

        //Binary Serach 
         
         int left=0;
         int right = list.size() - 1;

        String result = "";

         while(left<=right){
            int mid = (left+right)/2;

            if(list.get(mid).timestamp <= timestamp){ //pair.timestamp 
                result = list.get(mid).value;
                left= mid +1;
            }
            else{
                right = mid - 1;
            }


         }
         return result;
        
    }
}
