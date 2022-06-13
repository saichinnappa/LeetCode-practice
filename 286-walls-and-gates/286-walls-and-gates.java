class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        
        Deque<Cell> queue = new LinkedList<>();
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(rooms[i][j] == 0)
                    queue.offer(new Cell(i, j, 0));
            }
        }
        
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()){
            Cell first = queue.poll();
            for(int[] d : directions){
                int newRow = first.row + d[0];
                int newCol = first.col + d[1];
                if(newRow > -1 && newCol > -1 && newRow < m && newCol < n && rooms[newRow][newCol] == Integer.MAX_VALUE){
                    rooms[newRow][newCol] = first.dist + 1;
                    queue.offer(new Cell(newRow, newCol, first.dist + 1));
                }
            }
            
        }
        
    }
}

class Cell{
    int row;
    int col;
    int dist;
    
    Cell(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}