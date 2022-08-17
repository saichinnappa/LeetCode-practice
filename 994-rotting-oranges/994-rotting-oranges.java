class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        Deque<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                } else if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if(freshOranges == 0)
            return 0;
    
        while(!queue.isEmpty()){
            int size = queue.size();
            time++;
            while(size != 0){
                size--;
                int[] first = queue.poll();
                for(int[] d : dirs){
                    int r = first[0] + d[0];
                    int c = first[1] + d[1];
                    if(r > -1 & c > -1 && r < m && c < n && grid[r][c] == 1){
                        freshOranges--;
                        grid[r][c] = 2;
                        queue.offer(new int[]{r, c});
                        if(freshOranges == 0)
                            return time;
                    }
                }
            }
        }
    return -1;    
    }
    
}