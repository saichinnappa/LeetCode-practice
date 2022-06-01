class Solution {
    int[][] grid;
    int area;
    int result = 0;
    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    maxArea(i, j);
                    area = 0;
                }
            }
        }
        return result;
    }
    
    void maxArea(int row, int col){
        if(row > -1 && col > -1 && row < this.grid.length && col < this.grid[row].length && this.grid[row][col] == 1 ){
            area++;
        } else{
            return;
        }
                    this.grid[row][col] = -1;
        maxArea(row + 1, col);
        maxArea(row, col + 1);
        maxArea(row, col - 1);
        maxArea(row - 1, col);
        result = Math.max(result, area);
    }
    
}