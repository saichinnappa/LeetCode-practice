class HitCounter {
    
    Deque<Integer> pq;

    public HitCounter() {
        pq = new LinkedList<Integer>();
    }
    
    public void hit(int timestamp) {
        pq.offer(timestamp);
    }
    
    public int getHits(int timestamp) {
        
        while(pq.size() > 0 && timestamp - pq.peek() >= 300){
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