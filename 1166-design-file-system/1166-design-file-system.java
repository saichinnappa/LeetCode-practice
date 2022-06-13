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
    
    
    
    private void deletePath(String path){
        String[] p = path.split("/");
        TrieNode curr = root;
        String[] p1 = new String[p.length - 1];
        for(int i = 1; i < p.length; i++){
            p1[i - 1] = p[i];
        }
        deleteNode(p1, 0, root);
    }

    static void deleteNode(String[] p1, int level, TrieNode node){
        if(level == p1.length - 1){
            TrieNode curr = node.children.get(p1[level]);
            if(curr.children.size() == 0){
                node.children.remove(p1[level]);
                System.out.println(" deleted successfully ");
                return;
            } else{
                System.out.println(" children exists, cannot delete node ");
                return;
            }
        }

        if(node.children.containsKey(p1[level])){
            deleteNode(p1, level + 1, node.children.get(p1[level]));
        } else{
            System.out.println("Parent doesn't exist");
        }

    }
    
    
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * boolean param_1 = obj.createPath(path,value);
 * int param_2 = obj.get(path);
 */