class Solution {
    boolean exists = false;
       boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    backtrack(board, word, 0, i, j);
                    if(exists){
                        System.out.println("---=here--");
                        return true;
                    }
                }
            }
        }
        
        return exists;
    }
    
    
    void backtrack(char[][] board, String word, int index, int row, int col){
        int x = 0;
        if(row > -1 && row < board.length && col > -1 && col < board[0].length && index < word.length() && board[row][col] == word.charAt(index) && !visited[row][col]){
            visited[row][col] = true;
        } else{
            return;
        }
        

        if(word.length() - 1 == index){
                    System.out.println(index);
            exists = true;
            return;
        }
        
        backtrack(board, word, index + 1, row + 1, col);
        backtrack(board, word, index + 1, row, col + 1);
        backtrack(board, word, index + 1, row - 1, col);
        backtrack(board, word, index + 1, row, col - 1);
        visited[row][col] = false;   
        
    }
}