class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //[73,74,75,71,69,72,76,73]

        int[] result = new int[temperatures.length]; 
        //create int array of length of temperatures array [0,0,0,0..]
        Stack<Integer> stack = new Stack<>();
        //create an empty stack []
        //stack is to store indices not temperatures

        for(int i=0; i <temperatures.length; i++){
            while(!(stack.isEmpty()) && (temperatures[i]> temperatures[stack.peek()])){
                int prevIndex = stack.pop(); //pops 0th index
                result[prevIndex] = i - prevIndex;
                //0 = 1 - 0 = 1
            }
            stack.push(i);
        }
        return result;
    }
}
