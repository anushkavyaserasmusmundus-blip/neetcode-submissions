class Solution {
    public boolean isValid(String s) {
        //create stack
        Deque<Character> stack = new ArrayDeque<>();

        //traverse the string
        for(char ch : s.toCharArray()){    
            if(ch == '(' || ch == '{' || ch == '[' ){
            stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                } //do we have an opening bracket to match this closing bracker?

                char top = stack.pop(); //this pops the last opening bracket
                //ch is still moving and will now represent your next index value which is closing bracket
                if( (ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')){
                        return false;
                    }
            }
        }
        return stack.isEmpty(); //after traversing are there any opening brackets left?
    }
}