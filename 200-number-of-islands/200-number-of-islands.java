class Solution {
    char[][] grid;
    int m, n;
    int result = 0;
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int numIslands(char[][] grid) {
        Deque<int[]>queue = new LinkedList<>();
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    result++;
                    queue.offer(new int[]{i, j});
                    while(!queue.isEmpty()){
                        int[] first = queue.poll();
                        for(int[] dir : dirs){
                            int row = first[0] + dir[0];
                            int col = first[1] + dir[1];
                            if(row > -1 && col > -1 && row < m && col < n && grid[row][col] == '1'){
                                grid[row][col] = 'X';
                                queue.offer(new int[]{row,col});
                            }
                        }
                    }
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