class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int result = 0;
        for(String s : tokens){
            switch(s){
                case "+": 
                    int x = stack.pop();
                    int y = stack.pop();
                    stack.push(x + y);
                    break;
                case "*":
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(a * b);
                    break;
                case "-":
                    int c = stack.pop();
                    int d = stack.pop();
                    stack.push(d - c);
                    break;
                    
                case "/":
                    int e = stack.pop();
                    int f = stack.pop();
                    stack.push(f / e);
                    break;    
                default:
                    stack.push(Integer.valueOf(s));
                    break;
            }
        }
        
        return stack.pop();
    }
}