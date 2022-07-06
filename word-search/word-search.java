class Solution {
    boolean found = false;
    char[][] board;
    int m, n;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        this.visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(i, j, 0, word);
                    if(found)
                        return true;
                }
            }
        }
        return false;
    }
    
    
    void dfs(int row, int col, int index, String word){
        if(row > -1 && col > -1 && row < m && col < n && !visited[row][col] && board[row][col] == word.charAt(index)){
            if(index == word.length() -1){
                found = true;
                return;
            }
            visited[row][col] = true;
            dfs(row + 1, col, index + 1, word);
            dfs(row - 1, col, index + 1, word);
            dfs(row, col + 1, index + 1, word);
            dfs(row, col - 1, index + 1, word);
            visited[row][col] = false;
        }
    }
}