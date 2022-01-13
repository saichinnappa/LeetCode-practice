class Solution {
    public int orangesRotting(int[][] grid) {
        
        int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int timeElapse = -1;
        // ######### BFS ##########
        
        int freshOranges = 0;
        List<Pair> graph = new ArrayList();
        
        //FreshOranges count and build graph for rottern oranges
        for(int i=0; i< grid.length; i++){
            for(int j=0; j< grid[i].length; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                } else if (grid[i][j] == 2){
                    graph.add(new Pair(i, j));
                }
            }
        }
        
        
        // BFS start
        Queue<Pair> queue = new ArrayDeque();
        
        queue.addAll(graph);
        queue.offer(new Pair(-1,-1));
        
        while(!queue.isEmpty()){
            Pair first = queue.poll();
            int row = first.row;
            int col = first.col;
            
            if(row == -1){
                timeElapse++;
                if(!queue.isEmpty()){
                    queue.offer(new Pair(-1, -1));
                }
            }
            else{
                for(int[] dir : direction){
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if(newRow >= 0 && newCol >= 0 && newRow < grid.length && newCol < grid[0].length && grid[newRow][newCol] == 1){
                        freshOranges--;
                        grid[newRow][newCol] = 2;
                        queue.offer(new Pair(newRow, newCol));
                    }
                }
            }
            
        }
        
        
        return freshOranges == 0 ? timeElapse : -1;    
        
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