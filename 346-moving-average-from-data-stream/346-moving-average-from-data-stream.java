class MovingAverage {
    List<Integer> list = new ArrayList<>();
    int maxSize;
    double sum = 0.0;

    public MovingAverage(int size) {
        this.maxSize = size;
    }
    
    public double next(int val) {
        if(list.size() == maxSize){
            sum -= list.get(0);
            list.remove(0);
        }
        sum += val;
        list.add(val);
        return (sum/list.size());
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */