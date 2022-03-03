class LRUCache {

    Map<Integer, DLL> cache = new HashMap();
    DLL head, tail;
    int capacity =0, size =0;
    
    public LRUCache(int capacity) {
        
        this.capacity = capacity;
        
        head = new DLL(-10, -10, null, null);
        tail = new DLL(-10, -10, null, null);
        
        head.next = tail;
        tail.prev = head;
        
    }
    
    // If key does not exists in cache, return -1
    // if exists, since key is accessed move it to head
    //to move to head delete the existing connections to the node, and then move the node next to head;
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        
        DLL node = cache.get(key);
        
        removeNode(node);
        addNextToHead(node);
        
        return node.val;
        
    }
    // If key already exists in cache, replace the value with new Value and move the node next to head
    // If key doesn't exist, create a new Node and next to head and also add to cache
    public void put(int key, int value) {
       if(cache.containsKey(key)){
           DLL node = cache.get(key);
           removeNode(node);
           node.val = value;
           DLL newNode = addNextToHead(node);
           cache.put(key, newNode);
       } else{
           DLL newNode = new DLL (key, value, null,null);
           size++;
           if(size > capacity){
               int tailKey = removeTailNode();
               cache.remove(tailKey);
           }
                addNextToHead(newNode);
                cache.put(key, newNode);
           
           
       }
    }
    
    public void removeNode(DLL node){
        
        DLL prev = node.prev;
        DLL next = node.next;
        prev.next = next;
        next.prev = prev;
        
    }
    
    public DLL addNextToHead(DLL node){
        
        DLL headNext = head.next;
        head.next = node;
        node.prev = head;
        node.next = headNext;
        headNext.prev = node;
        return node;
        
    }
    
    public int removeTailNode(){
        
        DLL prev = tail.prev;
        removeNode(prev);
        return prev.key;
    }
    
}

class DLL{
    int val;
    int key;
    DLL prev;
    DLL next;
    
    DLL(int key, int val, DLL prev, DLL next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}