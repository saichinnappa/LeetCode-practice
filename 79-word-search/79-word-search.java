class Solution {
    boolean[][] visited;
    boolean exists = false;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    backtrack(i, j, 0, board, word);
                }
            }
        }
        return exists;
    }
    
    public boolean backtrack(int i, int j, int index, char[][] board, String word){
        if(i > -1 && i < board.length && j > -1 && j < board[0].length && index < word.length()
          && !visited[i][j] && board[i][j] == word.charAt(index)){
            visited[i][j] = true;
        } else
            return false;
        
        if(index == word.length() - 1)
            exists = true;
        
        backtrack(i, j + 1, index + 1, board, word);
        backtrack(i + 1, j, index + 1, board, word);
        backtrack(i, j - 1, index + 1, board, word);
        backtrack(i - 1, j, index + 1, board, word);
        visited[i][j] = false;
        return exists;
    }
    
    
}