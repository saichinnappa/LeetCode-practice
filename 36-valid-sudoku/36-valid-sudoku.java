class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        Map<Integer, Set<Character>> map = new HashMap();
        
        //rows
        for(int i=0; i<board.length; i++){
            Set<Character> value = new HashSet<Character>();
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] != '.'){
                    if(!value.contains(board[i][j]))
                    value.add(board[i][j]);
                else
                    return false;
                }
            }
        }
        
        //cols
         for(int i=0; i<board.length; i++){
            Set<Character> value = new HashSet<Character>();
            for(int j=0; j<board[i].length; j++){
                 if(board[j][i] != '.'){
                   if(!value.contains(board[j][i]))
                    value.add(board[j][i]);
                else
                    return false;
                }
            }
         }
        
        
        //for boxes
        for(int i = 0; i< board.length; i++){
            for(int j = 0; j< board[i].length; j++){
                int boxValue = ((i / 3) * 3) + (j / 3);
                if(board[i][j] != '.'){
                    if(!map.containsKey(boxValue)){
                        map.put(boxValue, new HashSet<Character>(Arrays.asList(board[i][j])));
                    } else{
                        if(map.get(boxValue).contains(board[i][j])){
                            return false;
                        } else{
                            map.get(boxValue).add(board[i][j]);
                        }
                    }
                }
                
            }
        }
        
        
//         //squre
//         for(int i=0; i<board.length; i++){
//             for(int j=0; j<board[i].length; j++){
//                 int x = board[i][j];
//                 int jIndex = j;
//                 if(j % 3 == 0){
//                     int count =0;
//                     while(count != 2){
//                         jIndex++;
//                         if(x == board[i][jIndex])
//                             return true
//                          count++;
//                     }
//                 }
                    
                
                
                
//             }
//         }
        
        
            
        return true;
        
    }
}