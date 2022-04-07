class Solution {
    boolean exists = false;
    boolean[][] visited;
    char[][] board;
    int result;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        visited = new boolean[board.length][board[0].length];
        for(int i =0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(i, j, 0, word);
                    if(exists)
                        return true;
                }
            }
        }
        return false;
    }
    
    
    void dfs(int row, int col, int index, String word){
        if(row > -1 && row < board.length && col > -1 && col < board[0].length && index < word.length() && !visited[row][col] && word.charAt(index) == board[row][col]){
            visited[row][col] = true;
        } else{
            return;
        }
        // if(word.charAt(index) == board[row][col]){
            
            if(index == word.length() - 1){
                exists = true;
                return;
            // }
        }
        
        dfs(row + 1, col, index + 1, word);
        dfs(row - 1, col, index + 1, word);
        dfs(row, col + 1, index + 1, word);
        dfs(row, col - 1, index + 1, word);
        visited[row][col] = false;
    }
    
}