// class Solution {
//     char[][] grid;
//     int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
//     int distance = 0;
//     public int getFood(char[][] grid) {
//         this.grid = grid;
//         if(grid.length == 0 || grid == null)
//             return -1;
        
//         int m = grid.length;
//         int n = grid[0].length;
        
//         Deque<int[]> queue = new LinkedList<>();
        
//         for(int i = 0; i < m; i++){
//             for(int j = 0; j < n; j++){
//                 if(grid[i][j] == '*'){
//                     grid[i][j] = (char)0;
//                     queue.offer(new int[]{i, j, 0});
//                 }
//             }
//         }
        
        
        
//         while(!queue.isEmpty()){
//             int[] first = queue.poll();
//             int dist = (int)first[2];
//             for(int[] dir : directions){
//             int newRow = first[0] + dir[0];
//             int newCol = first[1] + dir[1];
//             if(newRow > -1 && newCol > -1 && newRow < grid.length && newCol < grid[0].length){
//                 if(grid[newRow][newCol] == 'O'){
//                     grid[newRow][newCol] = (char)(dist + 1);
//                     queue.offer(new int[]{newRow, newCol, (char)(dist + 1)});
//                 } else if (grid[newRow][newCol] == '#')
//                     return (dist + 1);
//             }
//         }
//         }
        
        
//         return -1;
//     }
    
    
// }

class Solution {
    public int getFood(char[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        
        Queue<int[]> q = new LinkedList();
        int steps = -1;
        
        for(int i = 0 ; i < row ; i++)
        {
            for(int j = 0 ; j < col; j++)
            {
                if(grid[i][j] == '*')
                {
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        int[][] dir = new int[][]{{-1,0}, {0,1}, {1,0}, {0, -1}};
        
        while(!q.isEmpty())
        {
            int len = q.size();
            steps++;
            for(int i = 0 ; i < len ; i++)
            {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
            
                if(grid[r][c] == '#')
                {
                    return steps;
                }
                
                for(int[] d : dir)
                {
                    
                    int newr = r + d[0];
                    int newc = c + d[1];

                    if((newr >= 0 && newr < row && newc >=0 && newc < col) && (grid[newr][newc] == 'O' || grid[newr][newc] == '#'))
                    {
                        grid[newr][newc] = grid[newr][newc] == 'O'? 'X' : grid[newr][newc];
                        q.add(new int[]{newr, newc});
                    }
                }
            }
        }
        
        return -1;
        
    }
}