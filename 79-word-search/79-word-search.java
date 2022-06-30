class Solution {
    boolean[][] visited;
    char[][] board;
    boolean found = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        this.visited = new boolean[m][n];
        this.board = board;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(i, j, m, n, 0, word);
                    if(found)
                        return true;
                }
            }
        }
            
        return false;
    }
    
    void dfs(int row, int col, int m, int n, int idx, String word){
        if(row > -1 && col > -1 && row < m && col < n && !visited[row][col] && idx < word.length() && board[row][col] == word.charAt(idx)){
            visited[row][col] = true;
            if(idx == word.length() - 1)
                found = true;
            dfs(row + 1, col, m, n, idx + 1, word);
            dfs(row, col + 1, m, n, idx + 1, word);
            dfs(row - 1, col, m, n, idx + 1, word);
            dfs(row, col - 1, m, n, idx + 1, word);
            visited[row][col] = false;
        }

    }
}