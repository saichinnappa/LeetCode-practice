class TimeMap {
    
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList<Pair>());    
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return "";
        int start = 0;
        int end = map.get(key).size() - 1;
        List<Pair> list = map.get(key);
        String result = "";
        while(start <= end){
            int mid = (start) + (end - start) / 2;
            if(list.get(mid).key <= timestamp){
                result = list.get(mid).val;
                start = mid + 1;
            } else{
                end = mid - 1;
            }
        }
        
        return result;
    }
}

class Pair{
    int key;
    String val;
    
    Pair(int key, String val){
        this.key = key;
        this.val = val;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */