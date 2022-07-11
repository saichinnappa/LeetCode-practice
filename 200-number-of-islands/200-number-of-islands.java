class Solution {
    int result = 0;
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
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
        } else
            return;
        dfs(row + 1, col, m, n);
        dfs(row, col + 1, m, n);
        dfs(row, col - 1, m, n);
        dfs(row - 1, col, m, n);
    }
}