class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>(); //{}

        for(String s : strs){   //s = "eat"

            int count [] = new int [26]; //count = [0,0...0]
            for(char c : s.toCharArray()){ // c = 'e' -> 'a' -> 't'
                count[c - 'a']++; //e-a = 4
            }                   // before - count[4]=0 ; 
                                 //         count[4]++;
                                 // after - count[4]=1;
                                 // a b c d e...t
                                 // t 0 0 0 1...1

            String key = Arrays.toString(count); //key = "[1,0,0,0,1...1,0,0,,]"

            if(!map.containsKey(key)){ //check the map
                map.put(key, new ArrayList<>()); //create new ArrayList<>() and sotre the key in it
                //map -----key-> ["eat","tea"]
                //     ----key-> ["tan"]
            }

            map.get(key).add(s);


        }

        return new ArrayList<>(map.values());
        
    }
}