class FileSystem {
   TrieNode root;
    
    public FileSystem() {
        root= new TrieNode();        
    }
    
    public List<String> ls(String path) {
     List<String> fileList = new ArrayList<String>();   
     TrieNode node =root; 
     String[] pathArr = path.split("/");   
     for(int i=1;i<pathArr.length;i++){
         //or alternative start path from i=1
         if(node.children.containsKey(pathArr[i])){
              node= node.children.get(pathArr[i]);
            }
        }   
        
        //curveball 1
        // If path is a file path, returns a list that only contains this file's name.
        if(node.word!=null){
            fileList.add(pathArr[pathArr.length-1]);
        }
        else{    
            for (String s: node.children.keySet()){
                fileList.add(s);
            }
            Collections.sort(fileList);
        }
        

        return fileList;
    }

    public TrieNode mkdirAndGetNode(String path){
        TrieNode node= root;        
        String[] pathArr= path.split("/");
        for(int i=0;i<pathArr.length;i++){
           if(pathArr[i]=="")
                continue;
           if(!node.children.containsKey(pathArr[i]))
               node.children.put(pathArr[i],new TrieNode());
            node= node.children.get(pathArr[i]);
        }    
        //node.word=path;
        return node;
    }
    
    public void mkdir(String path) {
        mkdirAndGetNode(path);
    }
    
    public void addContentToFile(String filePath, String content) {
        TrieNode node = mkdirAndGetNode(filePath); 
        if(node.word!=null)
            node.word+=content;
        else
            node.word=content;
    }

    public String readContentFromFile(String filePath) {
      TrieNode node= root;
      String[] pathArr= filePath.split("/");
        for(int i=0;i<pathArr.length;i++){
            if(pathArr[i]=="")
                continue;
           if(!node.children.containsKey(pathArr[i]))
               node.children.put(pathArr[i],new TrieNode());
            node= node.children.get(pathArr[i]);
        }
        return node.word;
    }
}

class TrieNode{
    Map<String,TrieNode> children= new HashMap<String,TrieNode>();
    String word=null;
    
}