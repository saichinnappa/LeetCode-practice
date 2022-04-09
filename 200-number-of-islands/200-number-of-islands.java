class Solution {
    int result = 0;
    int row, col;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.row = grid.length;
        this.col = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(i, j);
                    
                }
            }
        }
        
        return result;
    }
    
    void dfs(int r, int c){
        if(r < 0 || r >= row || c < 0 || c >= col || this.grid[r][c] != '1')
            return;
        this.grid[r][c] = 'X';
        
        dfs(r + 1, c);
        dfs(r, c + 1);
        dfs(r - 1, c);
        dfs(r, c - 1);
    }
}