class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
            //["eat","tea","ate"]
        Map<String, List<String>> map = new HashMap<>();
            //key-> 

        //look through each string "eat" at a time
        for (String s : strs) {

            //frequency array each index represents a letter
            int[] count = new int[26];
            
            //loop through each char in string 'e''a''t'
            for (char c : s.toCharArray()) {
                count[c - 'a']++; //get the index of each char and store into count
            }

            // Convert frequency array into a String key
            String key = Arrays.toString(count);
            //store in key = convert array to string

            // Add string to its corresponding group
            //this checks the hashmap
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
                //put it into a new array list
            }

            map.get(key).add(s);
            //adds tea to eat 
        }

        return new ArrayList<>(map.values());
    }
}
//'a' - 'a' = 0
//'b' - 'a' = 1
//'c' - 'a' = 2
//'d' - 'a' = 3
//...
//'z' - 'a' = 25