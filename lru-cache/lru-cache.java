class LRUCache {
    
    DLLNode head;
    DLLNode tail;
    int capacity;
    int size;
    Map<Integer, DLLNode> map;
    public LRUCache(int capacity) {
        this.head = new DLLNode(-1, -1, null, null);
        this.tail = new DLLNode(-1, -1, null, null);
        this.head.next = tail;
        this.tail.prev = head;
        this.capacity = capacity;
        this.map = new HashMap<Integer, DLLNode>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            DLLNode node = map.get(key);
            removeNode(node);
            addNextToHead(node);
            return node.val;
        } else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        
        DLLNode newNode = new DLLNode(key, value, null, null);
        if(map.containsKey(key)){
            DLLNode n = map.get(key);
            removeNode(n);
        } else{
            
            if(size == capacity){
                int k = removeTail();
                
                map.remove(k);
            } else{
                size++;
            }
        }
        addNextToHead(newNode);
        map.put(key, newNode);
        
        
    }
    
    void addNextToHead(DLLNode node){
        DLLNode headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
    }
    
    void removeNode(DLLNode node){
        DLLNode next = node.next;
        DLLNode prev = node.prev;
        next.prev = prev;
        prev.next = next;
    }
    
    int removeTail(){
        DLLNode tailPrev = tail.prev;
        removeNode(tailPrev);
        return tailPrev.key;
    }
}

class DLLNode{
    int key;
    int val;
    DLLNode prev;
    DLLNode next;
    
    DLLNode(int key, int val, DLLNode prev, DLLNode next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */