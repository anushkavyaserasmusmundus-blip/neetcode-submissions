class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length]; 
        //create int array of length of temperatures array
        Stack<Integer> stack = new Stack<>();
        //create an empty stack

        for(int i=0; i <temperatures.length; i++){
            while(!(stack.isEmpty()) && (temperatures[i]> temperatures[stack.peek()])){
                int prevIndex = stack.pop();
                result[prevIndex] = i - prevIndex;

            }
            stack.push(i);
        }
        return result;
    }
}
