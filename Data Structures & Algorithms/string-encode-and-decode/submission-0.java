class Solution {

    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        //build or change text in place -> mutable
        
        for(String str : strs){
            result.append(str.length()).append("#").append(str);
        } 

        return result.toString();
        //string is a mutable object
        //string builder is a helper class which is immutable

    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        //index

        while(i<str.length()){ //traverse
            int j =i; //i - j
            //dstores length of each substring

            while (str.charAt(j) != '#'){
                j++;  
                      
            }

          
            int length = Integer.parseInt(str.substring(i,j));//5
            //parseInt always make everything(text) a integer no

            String s = str.substring(j + 1, j + 1 + length);
            //                          (h      h--> length(5)) uptop but not including last

            result.add(s);

            i = j + 1 + length;
        }
        return result;
    }
}
