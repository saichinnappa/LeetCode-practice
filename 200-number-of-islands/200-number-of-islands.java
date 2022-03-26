class Solution {
    public int numIslands(char[][] grid) {
        //DFS
        int result = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(grid, i , j);
                }
            }
        }
        return result;
    }
    
    
    void dfs(char[][] grid, int i, int j){
        if(i < grid.length && i > -1 && j < grid[0].length && j > -1 && grid[i][j] == '1'){
            grid[i][j] = 'X';
        } else{
            return;
        }
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i - 1,  j);
        dfs(grid, i, j - 1);
    }
    
}