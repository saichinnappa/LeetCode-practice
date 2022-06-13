class FileSystem {

    Map<String, Integer> fileSystem;
    
    public FileSystem() {
        fileSystem = new HashMap<>();
    }
    
    public boolean createPath(String path, int value) {
        if(path.equals("")  || path.equals("/") || fileSystem.containsKey(path))
            return false;
        int lastIndex = path.lastIndexOf("/");
        if(lastIndex == 0){
            fileSystem.put(path, value);
            return true;
        }
        String parent = path.substring(0, lastIndex);
        if(fileSystem.containsKey(parent)){
            fileSystem.put(path, value);
            return true;
        }
        return false;
    }
    
    public int get(String path) {
        return fileSystem.containsKey(path) ? fileSystem.get(path) : -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */