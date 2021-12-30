class Solution {
    
    List<List<String>> result = new ArrayList();
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        
        //Binary Search
        Arrays.sort(products);
        // System.out.println(Arrays.toString(products));
        char[] arr = searchWord.toCharArray();
        
        String prefix = "";
        int start = 0;
        int end = products.length - 1;
        
        
        
        for(int i = 0; i< arr.length; i++){
            prefix += arr[i];
            int idx = binarySearch(products, prefix, start, end);
            // System.out.println("IDX: "+idx+" | PREFIX: "+prefix);
            result.add(new ArrayList());
            for(int j = idx; j< Math.min(idx + 3, products.length); j++){
                if(products[j].startsWith(prefix))
                result.get(result.size() - 1).add(products[j]);
            }
            start = idx;
        }
        
        return result;
        
        
        
        
//         if(searchWord.length() == 0)
//             return result;
        
//         //BruteForce
//         // int start = 0;
//         // int end = 1;
//         // Arrays.sort(products);
//         // char[] arr = searchWord.toCharArray();
//         // for(Character c : arr){
//         //     helper(products, searchWord, start, end);    
//         //     end = end + 1;
//         // }
//         Trie trie = new Trie();
//         for(String s: products){
//             trie.insert(s);
//         }
//         char[] arr = searchWord.toCharArray();
//         int end = 1;
//         for(Character c : arr){
//             LinkedList<String> list = trie.search(searchWord.substring(0, end));    
//             while(list.size() > 3){
//                 list.removeLast();
//             }
//             result.add(list);
//             end = end + 1;
//         }
        
//         return result;
    }
    
    
    int binarySearch(String[] products, String prefix, int start,  int end){
        while(start < end){
            int mid = (start + end)/2;
            // System.out.println("MID: "+mid);
            if(products[mid].compareTo(prefix) >= 0){
                end = mid;
            } else{
                start = mid + 1;
            }
        }
        return start;
    }
    
//     void helper(String[] products, String searchWord, int start, int end){
//         LinkedList<String> list = new LinkedList();
//         String subString = searchWord.substring(start, end);
//         for(int i = 0; i< products.length; i++)
//         {
//             if(products[i].length() >= end && products[i].startsWith(subString)){
//                 list.add(products[i]);
//             }
//         }
//         int size = list.size();
//         while(size > 3){
//             list.removeLast();
//             size--;
//         }
    
//         result.add(list);
//     }
}

class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    
    TrieNode(){
        this.children = new TrieNode[26];
        this.isEnd = false;
    }
    
    void markAsLeaf(){
        this.isEnd = true;
    }
}

class Trie{
    TrieNode root;
    char[] children = new char[26];
    boolean isEnd = false;
    
    Trie(){
        this.root = new TrieNode();
    }
    
    int getIndex(char c){
           return  c - 'a';
    }
    
    void insert(String key){
        if(key == null)
            return;
        
        TrieNode currentNode = this.root;
        int index = 0;
        
        for(int i = 0; i < key.length(); i++){
            index = getIndex(key.charAt(i));
            if(currentNode.children[index] == null){
                currentNode.children[index] = new TrieNode();
            }
            currentNode = currentNode.children[index];
        }
        currentNode.markAsLeaf();
    }
    
    
    LinkedList<String> search(String key){
        LinkedList<String> list = new LinkedList();
        
        TrieNode currentNode = this.root;
        int index = 0, level = 0, j = 0;
        char[] arr = new char[3000];
        for(int i = 0; i< key.length(); i++){
            index = getIndex(key.charAt(i));
            if(currentNode.children[index] != null){
                arr[level++] = key.charAt(i);
                currentNode = currentNode.children[index];
            } else{
                return list;
            }
                
        }

        getWords(key, currentNode, list, arr, level);
        
        return list;
        
    }
    
    void getWords(String key, TrieNode currentNode, List<String> list, char[] arr, int level){
        if(currentNode.isEnd){
            String word = "";
            for(int i = 0; i < level; i++){
                word += arr[i];
            }
            list.add(word);
        }
        int index = 0;
        for(int i = 0; i < currentNode.children.length; i++){
            if(currentNode.children[i] != null){
                arr[level] = (char) (i + 'a');
                getWords(key, currentNode.children[i], list, arr, level + 1);
            }

        }
        
    }
    
}
