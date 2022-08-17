class Solution {
    char[][] grid;
    int m, n;
    int result = 0;
    public int numIslands(char[][] grid) {
        
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;
    }
    
    
    void dfs(int row, int col){
        if(row > -1 && col > -1 && row < m && col < n && grid[row][col] == '1'){
            grid[row][col] = 'X';
            dfs(row + 1, col);
            dfs(row - 1, col);
            dfs(row, col + 1);
            dfs(row, col - 1);
        } else{
            return;
        }
    }
    
}