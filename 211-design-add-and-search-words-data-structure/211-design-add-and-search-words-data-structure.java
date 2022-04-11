class WordDictionary {

    TrieNode root;
    
    public WordDictionary() {
        this.root = new TrieNode();    
    }
    
    public void addWord(String word) {
        if(word == null || word.length() == 0)
            return;
        TrieNode current = this.root;
        for(int i = 0; i < word.length(); i++){
            int c = word.charAt(i) - 'a';
            if(current.children[c] == null)
                current.children[c] = new TrieNode();
            current = current.children[c];
        }
        current.isLeaf = true;
        
    }
    
    public boolean search(String word) {
        TrieNode current = this.root;
        return helper(current, word, 0);
    }
    
    boolean helper(TrieNode current, String word, int index){
        if(index == word.length()){
            return current.isLeaf;
        }
        char c = word.charAt(index);
        if(c == '.'){
            for(TrieNode node : current.children){
                if(node != null && helper(node, word, index + 1)){
                    return true;
                }
            }
        } else{
            if(current.children[c - 'a'] == null)
                return false;
            else{
                current = current.children[c - 'a'];
                return helper(current, word, index + 1);
            }
            
        }
        return false;
    }
}

class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isLeaf = false;
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */