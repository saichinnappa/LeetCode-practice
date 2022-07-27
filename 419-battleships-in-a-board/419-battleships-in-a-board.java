class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X'){
                    result++;
                    dfs(i, j, m, n, board);
                }
            }
        }
        
        return result;
    }
    
    void dfs(int row, int col, int m, int n, char[][] board){
        if(row > -1 && col > -1 && row < m && col < n && board[row][col] == 'X'){
            board[row][col] = 'Y';
        } else{
            return;
        }
        
        dfs(row + 1, col, m, n, board);
        dfs(row - 1, col, m, n, board);
        dfs(row, col + 1, m, n, board);
        dfs(row, col - 1, m, n, board);
        
    }
    
    
}