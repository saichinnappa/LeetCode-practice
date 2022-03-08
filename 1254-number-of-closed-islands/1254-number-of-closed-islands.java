class Solution {
    int totalIslands = 0;
    int[][] grid;
    public int closedIsland(int[][] grid) {
        this.grid = grid;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 0 && dfs(i, j)){
                    totalIslands++;                    
                }
            }
        }
        return totalIslands;
    }
    
    boolean dfs(int row, int col){
        if(row < 0 || col < 0 || row  >= grid.length || col >= grid[0].length){
            return false;
        }
        if(grid[row][col] == 1) return true;
        grid[row][col] = 1;
        return dfs(row + 1, col) &
        dfs(row, col + 1) &
        dfs(row - 1, col) &
        dfs(row, col - 1);
    }
    
    // boolean isIsland(int row, int col){
    //     int[] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    //     for(int[] d : directions){
    //         int newRow = row + d[0];
    //         int newCol = col + d[1];
    //         if(newRow > -1 && newCol > -1 && newRow < grid.length && newCol < grid[0].length
    //           && grid[newRow][newCol] == 1){
    //             return true;
    //         }
    //     }
    //     return false;
    // }
}