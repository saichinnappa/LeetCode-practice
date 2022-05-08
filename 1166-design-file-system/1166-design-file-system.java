class FileSystem {
    
    Map<String, Integer> map;

    public FileSystem() {
        map = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        
        if(path == "" || path == "/" || map.containsKey(path))
            return false;
        int lastIndex = path.lastIndexOf("/");
        if(lastIndex == 0){
                map.put(path, value);
                return true;
        } else{
            String subStr = path.substring(0, lastIndex);
            if(map.containsKey(subStr)){
                map.put(path, value);
                return true;
            }
        }
        return false;
    }
    
    public int get(String path) {
        return map.containsKey(path) ? map.get(path) : -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */