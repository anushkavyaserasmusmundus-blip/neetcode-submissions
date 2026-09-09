class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack  = new Stack<>();

        for(int i=0; i< tokens.length; i++){

            if(!(tokens[i].equals("+") ||
            tokens[i].equals("-") ||
            tokens[i].equals("*") ||
            tokens[i].equals("/"))){
                stack.push(Integer.parseInt(tokens[i]));
            }
            else{
                int first = stack.pop();
                int second = stack.pop();

                int result;
                if(tokens[i].equals("+")){
                    result = second + first;
                }
                else if(tokens[i].equals("-")){
                    result = second - first;
                }
                else if(tokens[i].equals("*")){
                    result = second * first;
                }
                else{
                    result = second / first;
                }

                stack.push(result); //store result as last element
            }
        }
        return stack.pop(); //pop last element
    }
}
