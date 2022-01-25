class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    

    public MaxStack() {
        stack = new Stack();
        maxStack = new Stack();
    }
    
    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty())
            maxStack.push(x);
        else{
            int maxTop = maxStack.peek();
            if(maxTop > x){
                maxStack.push(maxTop);
            } else{
                maxStack.push(x);
            }
        }
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> buffer = new Stack();
        while(top() != max)
            buffer.push(pop());
        pop();
        while(!buffer.isEmpty())
            push(buffer.pop());
        return max;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */