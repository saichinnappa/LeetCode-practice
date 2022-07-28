class Solution {
    public int countBattleships(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'X' && dfs(i, j, board)){
                    result++;
                }
            }
        }
        
        return result;
    }
    
    boolean dfs(int row, int col, char[][] board){
        
        if((row - 1) >= 0 && board[row - 1][col] == 'X') return false;
        if((col - 1) >= 0 && board[row][col - 1] == 'X') return false;
        
        return true;
    }
    
    
}