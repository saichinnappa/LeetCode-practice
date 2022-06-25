class Trie {

    TrieNode root;
    
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode current = root;
        for(int i = 0; i < arr.length; i++){
            if(current.children[arr[i]- 'a'] == null){
                current.children[arr[i] - 'a'] = new TrieNode();
            }
            current = current.children[arr[i] - 'a'];
        }
        current.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length(); i++){
            if(current.children[word.charAt(i) - 'a'] == null)
                return false;
            current = current.children[word.charAt(i) - 'a'];
        }
        return current.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(int i = 0; i < prefix.length(); i++){
            if(current.children[prefix.charAt(i) - 'a'] == null)
                return false;
            current = current.children[prefix.charAt(i) -'a'];
        }
        return true;
    }
    
    class TrieNode{
        TrieNode[] children;
        boolean isWord;
        
        TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }
    }
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */