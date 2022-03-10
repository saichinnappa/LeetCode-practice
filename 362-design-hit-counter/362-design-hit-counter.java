// class HitCounter {

//     Queue<Integer> queue;
//     public HitCounter() {
//         queue = new LinkedList<>();
//     }
    
//     public void hit(int timestamp) {
//         queue.offer(timestamp);
//     }
    
//     public int getHits(int timestamp) {
//         while(!queue.isEmpty()){
//             int diff = timestamp - queue.peek();
//             if(diff >= 300) queue.poll();
//             else break;
//         }
//         return queue.size();
//     }
// }

class HitCounter {

    Deque<Pair> queue;
    int total = 0;
    public HitCounter() {
        queue = new LinkedList<>();
    }
    
    public void hit(int timestamp) {
        if(!queue.isEmpty()){
            Pair first = queue.pollLast();
            if(first.timestamp == timestamp){
                queue.offer(new Pair(timestamp, first.count + 1));
            } else{
                queue.offer(first);
                queue.offer(new Pair(timestamp, 1));
            }
        } else{
            queue.offer(new Pair(timestamp, 1));
        }
        total++;
    }
    
    public int getHits(int timestamp) {
        // System.out.println(queue.getFirst().timestamp);
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