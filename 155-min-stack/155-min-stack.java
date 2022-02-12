class MinStack {
    
    List<Pair> list;

    public MinStack() {
        list = new ArrayList();
    }
    
    public void push(int val) {
        if(list.size() == 0){
            list.add(new Pair(val, val));
        } else{
            Pair p = list.get(list.size() -1);
            if(p.minVal < val){
                list.add(new Pair(val, p.minVal));
            } else{
                list.add(new Pair(val, val));
            }
        }
    }
    
    public void pop() {
        list.remove(list.size() - 1);
    }
    
    public int top() {
        
        int top = list.get(list.size() - 1).val;
        return top;
        
    }
    
    public int getMin() {
        int min = list.get(list.size() - 1).minVal;
        return min;
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