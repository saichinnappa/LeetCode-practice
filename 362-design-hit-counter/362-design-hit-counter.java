class HitCounter {

    Deque<Pair> queue;
    int total = 0;
    public HitCounter() {
        queue = new LinkedList();
    }
    
    public void hit(int timestamp) {
        if(!queue.isEmpty() && queue.peek().timestamp == timestamp){
            queue.offer(new Pair(timestamp, queue.poll().count + 1));
        } else{
            queue.offer(new Pair(timestamp, 1));
        }
        total++;
    }
    
    public int getHits(int timestamp) {
        while(!queue.isEmpty() && timestamp - queue.peek().timestamp >= 300){
            total -= queue.poll().count;
        }
        return total;
    }
}

class Pair{
    int timestamp;
    int count;
    
    Pair(int timestamp, int count){
        this.timestamp = timestamp;
        this.count = count;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */