class MyHashMap {

    LinkedList[] map;
    int maxVal = 2069;
    
    public MyHashMap() {
        map = new LinkedList[maxVal];
        for(int i = 0; i< maxVal; i++){
            LinkedList<Pair> list= new LinkedList();
            map[i] = list;
        }
    }
    
    public void put(int key, int value) {
        int hashKey = getHashKey(key);
        System.out.println("Key--->"+hashKey);
        Pair p = new Pair(key, value);
        LinkedList<Pair> list = map[hashKey];
        if(get(key)  != -1){
            remove(key);
            list.addLast(p);
            
        } else{

            list.addLast(p);
        }
    }
    
    public int get(int key) {
        int hashKey = getHashKey(key);
        LinkedList<Pair> list = map[hashKey];
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).key == key){
                System.out.println("Found Key: "+key);
                return list.get(i).val;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int hashKey = getHashKey(key);
        if(get(key) != -1){
            LinkedList<Pair> list = map[hashKey];
            for(int i = 0; i < list.size(); i++){
                if(list.get(i).key == key){
                    System.out.println("Removing Key--->"+key);
                    list.remove(i);
                }
            }
        }
    }
    
    public int getHashKey(int key){
        return key % maxVal;
    }
}

class Pair{
    int key;
    int val;
    
    Pair(int key, int val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */