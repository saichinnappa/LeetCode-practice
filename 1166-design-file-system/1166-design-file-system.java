class FileSystem {

    Map<String, Integer> map = new HashMap<>();
    
    public FileSystem() {
        
    }
    
    public boolean createPath(String path, int value) {
        if(path == "" || path == "/" || map.containsKey(path))
            return false;
        if(map.containsKey(path))
            return false;
        int lastIndex = path.lastIndexOf("/");
        if(lastIndex == 0){
            map.put(path, value);
            return true;
        }
        String parentPath = path.substring(0, lastIndex);
        if(map.containsKey(parentPath)){
            map.put(path, value);
            return true;
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