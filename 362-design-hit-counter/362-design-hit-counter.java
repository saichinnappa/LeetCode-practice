class HitCounter {
    
    PriorityQueue<Integer> pq;

    public HitCounter() {
        pq = new PriorityQueue<Integer>();
    }
    
    public void hit(int timestamp) {
        pq.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        while(!pq.isEmpty() && timestamp - pq.peek() >= 300){
            pq.poll();
        }
        return pq.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */