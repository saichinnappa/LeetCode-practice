class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowSet = new HashMap<>();
        Map<Integer, Set<Character>> colSet = new HashMap<>();
        Map<Integer, Set<Character>> blockSet = new HashMap<>();
        
        
        int m = board.length;
        int n = board[0].length;
        
        for(int i = 0; i < m; i++){
             rowSet.put(i, new HashSet<Character>());
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                if(val != '.'){
                    if(!rowSet.get(i).contains(val)){
                        rowSet.get(i).add(val);
                    } else
                        return false;    
                }
            }
        }
        
        
          for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                if(!colSet.containsKey(j))
                    colSet.put(j, new HashSet<Character>());
                if(val != '.'){
                    if(!colSet.get(j).contains(val)){
                        colSet.get(j).add(val);
                    } else
                        return false;    
                }
            }
        }
        
           for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                char val = board[i][j];
                int blockValue = (i / 3) * 3 + (j / 3);
                if(!blockSet.containsKey(blockValue))
                    blockSet.put(blockValue, new HashSet<Character>());
                if(val != '.'){
                    if(!blockSet.get(blockValue).contains(val)){
                        blockSet.get(blockValue).add(val);
                    } else
                        return false;    
                }
            }
        }
        
        return true;
    }
}