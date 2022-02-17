class Solution {
    int result = 0;
    int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    char[][] grid;
    public int numIslands(char[][] grid) {
        this.grid = grid;
        
// APPROACH 1: BFS        
//         
//         Queue<Pair> queue = new ArrayDeque<>();
//         for(int i = 0; i< grid.length;i++){
//             for(int j = 0; j < grid[i].length; j++){
//                 if(grid[i][j] == '1'){
//                     result++;
//                     grid[i][j] = 'X';
//                     queue.offer(new Pair(i, j));
//                     while(!queue.isEmpty()){
//                         Pair first = queue.poll();
//                         List<Pair> neighbors = getNeighbors(first.row, first.col);
//                         for(Pair nei : neighbors){
//                             queue.offer(nei);
//                         }
//                     }
                    
                    
//                 }
//             }
//         }
        
//         return result;
//     }
    
//     List<Pair> getNeighbors(int row, int col){
//         List<Pair> list = new ArrayList();
//         for(int[] d : directions){
//             int newRow = row + d[0];
//             int newCol = col + d[1];
//             if(newRow > -1 && newRow < grid.length && newCol > -1 && newCol < grid[0].length && grid[newRow][newCol] == '1'){
//                 grid[newRow][newCol] = 'X';
//                 list.add(new Pair(newRow, newCol));
//             }
//         }
//         return list;
//     }
        
        
        // APPROACH 2: DFS
        
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    result++;
                    dfs(i, j);
                }
            }
        }
        return result;
        
    }
    
    void dfs(int row, int col){
        if(row > -1 && row < grid.length && col > -1 && col < grid[0].length && grid[row][col] == '1'){
            grid[row][col] = 'X';
        } else{
            return;
        }
        

        dfs(row + 1, col);
        dfs(row, col + 1);
        dfs(row - 1, col);
        dfs(row, col - 1);
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