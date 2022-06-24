class MinStack {
    
    Stack<Pair> stack;

    public MinStack() {
        stack = new Stack<Pair>();
    }
    
    public void push(int val) {
        if(stack.isEmpty())
            stack.push(new Pair(val, val));
        else{
            int min = getMin();
            if(min < val)
                stack.push(new Pair(val, min));    
            else
                stack.push(new Pair(val, val));    
        }
        
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return stack.peek().minVal;
    }
}

class Pair{
    int val;
    int minVal;
    
    Pair(int val, int minVal){
        this.val = val;
        this.minVal = minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */