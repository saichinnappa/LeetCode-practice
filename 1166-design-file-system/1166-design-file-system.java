class TrieNode {
        String key;
        int value = -1;
        Map<String, TrieNode> children = new HashMap<>();

        public TrieNode(String key) {
            this.key = key;
        }

        public TrieNode() {
        }
}

class Path {
        String path;
        int value;

        public Path(String path, int value) {
            this.path = path;
            this.value = value;
        }
}

class FileSystem {

    TrieNode root;
    
    public FileSystem() {
        root = new TrieNode();
    }
    
    public boolean createPath(String path, int value) {
        String[] p = path.split("/");
        TrieNode curr = root;
        for (int j = 1; j < p.length; j++) {
            if (!curr.children.containsKey(p[j])) {
                if (j == p.length - 1) {
                    TrieNode node = new TrieNode(p[j]);
                    curr.children.put(p[j], node);
                } else {
                    return false;
                }
            }
            curr = curr.children.get(p[j]);
        }
        if (curr.value != -1)
            return false;
        curr.value = value;
        return true;
    }
    
    public int get(String path) {
       String[] p = path.split("/");
        TrieNode curr = root;
        for(int i = 1; i < p.length; i++){
            if(curr.children.containsKey(p[i])){
                curr = curr.children.get(p[i]);
                if(i == p.length - 1)
                    return curr.value;
            } else
                return -1;
        }
        return -1;
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */