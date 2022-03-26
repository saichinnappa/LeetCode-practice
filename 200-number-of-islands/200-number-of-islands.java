class Solution {
    public int numIslands(char[][] grid) {
        //DFS
        int result = 0;
        Queue<Pair> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    queue.offer(new Pair(i, j));
                                            grid[i][j] = 'X';
                    while(!queue.isEmpty()){
                        Pair p = queue.poll();

                        List<Pair> neigh = getNeighbors(p.row, p.col, grid);
                        for(Pair p1 : neigh){
                            queue.offer(p1);
                        }
                    }
                    
                    // dfs(grid, i , j);
                }
            }
        }
        return result;
    }
    
    
    
    List<Pair> getNeighbors(int row, int col, char[][] grid){
        List<Pair> list = new ArrayList<>();
        int[][] dist = {{1, 0}, {0,1}, {-1, 0}, {0, -1}};
        for(int i = 0; i < dist.length; i++){
            int newRow = row + dist[i][0];
            int newCol = col + dist[i][1];
            if(newRow < grid.length && newRow > -1 && newCol < grid[0].length && newCol > -1 && grid[newRow][newCol] == '1'){
                                     grid[newRow][newCol] = 'X';
                list.add(new Pair(newRow, newCol));
            } 
        }
        return list;
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

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}