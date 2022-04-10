class Trie {

    TrieNode root;
    
    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        if(word == null || word.length() == 0) return;
        TrieNode current = this.root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isLeafNode = true;
    }
    
    public boolean search(String word) {
        if(word == null || word.length() == 0)
            return true;
        TrieNode current = this.root;
        for(int i = 0; i < word.length(); i++){
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return current.isLeafNode;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null || prefix.length() == 0)
            return true;
        TrieNode current = this.root;
        for(int i = 0; i < prefix.length(); i++){
            int index = prefix.charAt(i) - 'a';
            if(current.children[index] == null)
                return false;
            current = current.children[index];
        }
        return true;
    }
}

class TrieNode{
    int size = 26;
    TrieNode[] children = new TrieNode[26];
    boolean isLeafNode;
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */