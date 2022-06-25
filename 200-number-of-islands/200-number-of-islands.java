class Solution {
    int result = 0;
    char[][] grid;
    int m = 0, n = 0;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(i, j, m, n);
                }
            }
        }
        return result;
    }
    
    
    void dfs(int row, int col, int m, int n){
        if(row > -1 && col > -1 && row < m && col < n && grid[row][col] == '1'){
            grid[row][col] = 'X';
        } else{
            return;
        }
        dfs(row + 1, col, m, n);
        dfs(row, col + 1, m, n);
        dfs(row - 1, col, m, n);
        dfs(row, col - 1, m, n);
    }
    
}