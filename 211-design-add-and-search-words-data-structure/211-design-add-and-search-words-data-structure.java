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
            int index = word.charAt(i) - 'a';
            if(current.children[index] == null)
                current.children[index] = new TrieNode();
            current = current.children[index];
        }
        current.isLeafNode = true;
        
    }
    
    public boolean search(String word) {
        TrieNode current = this.root; 
        return helper(current, word, 0);
    }
    
    boolean helper(TrieNode current, String word, int index){
        if(index == word.length()){
            if(current.isLeafNode)
                return true;
            else
                return false;
        }
        
        if(word.charAt(index) == '.'){
            for(TrieNode n : current.children){
                if(n != null && helper(n, word, index + 1)){
                    return true;
                }
            }
        } else{
            if(current.children[word.charAt(index) - 'a'] == null)
                return false;
            else{
                current = current.children[word.charAt(index) - 'a'];
                return helper(current, word, index + 1);
            }
                
        }
            
        return false;
            
    }
}


class TrieNode{
    TrieNode[] children = new TrieNode[26];
    boolean isLeafNode = false;
}


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */