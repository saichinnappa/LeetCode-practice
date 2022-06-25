class Solution {
    public int orangesRotting(int[][] grid) {
        int totalFresh = 0;
        int m = grid.length;
        int n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    totalFresh++;
                }
            }
        }
        
        
        
        Deque<int[]> queue = new LinkedList<int[]>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        if(totalFresh == 0)
            return 0;
        if(queue.isEmpty())
            return -1;
        
        int totalMinutes = 0;
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        while(!queue.isEmpty()){
            int size = queue.size();
            totalMinutes++;
            while(size != 0){
                size--;
                int[] first = queue.poll();
                for(int[] d : directions){
                    int newRow = d[0] + first[0];
                    int newCol = d[1] + first[1];
                    if(newRow > -1 && newCol > -1 && newRow < m && newCol < n && grid[newRow][newCol] == 1){
                        grid[newRow][newCol] = 2;
                        totalFresh--;
                        if(totalFresh == 0)
                            return totalMinutes;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
                        
        }
        
        return -1;
        
    }
}