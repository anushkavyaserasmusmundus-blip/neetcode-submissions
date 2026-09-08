class MinStack {
    Stack<Integer> stack; //declare the stack
    Stack<Integer> minStack; 

    public MinStack() { //constructor
        stack = new Stack<>(); //initialise it
        minStack = new Stack<>();
        
    }
    
    public void push(int val) {
        stack.push(val); //always push

        if(minStack.isEmpty() || val <= minStack.peek()){
            minStack.push(val); //only smallest value
        }
        
    }
    
    public void pop() {
        if(stack.peek().equals(minStack.peek())){
            minStack.pop(); //the min stack always has to be from the values present in the stack so remove from minstack if the value has been removed from the main stack
        }
        stack.pop();//just pop
        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return minStack.peek();
        
    }
}
