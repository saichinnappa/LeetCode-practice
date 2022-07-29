class Solution {
    int result = 0, curr = 0;
    int[][] grid;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, m, n);
                    result = Math.max(result, curr);
                    curr = 0;
                }
            }
        }
        return result;
    }
    
    
    void dfs(int row, int col, int m, int n){
        if(row > -1 && col > -1 && row < m && col < n && grid[row][col] == 1){
            curr++;
            grid[row][col] = 2;
        } else{
            return;
        }
        dfs(row + 1, col, m, n);
        dfs(row, col + 1, m, n);
        dfs(row - 1, col, m, n);
        dfs(row, col - 1, m, n);
    }
    
}