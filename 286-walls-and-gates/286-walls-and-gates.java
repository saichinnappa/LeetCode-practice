class Solution {
    public void wallsAndGates(int[][] rooms) {
        Deque<Pair> queue = new LinkedList<>();
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[i].length; j++){
                if(rooms[i][j] == 0){
                    queue.offer(new Pair(i, j));
                }
            }
        }
        int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        while(!queue.isEmpty()){
            Pair first = queue.poll();
            for(int[] dir : directions){
                int newRow = first.row + dir[0];
                int newCol = first.col + dir[1];
                if(newRow > -1 && newCol > -1 && newRow < rooms.length && newCol < rooms[0].length && rooms[newRow][newCol] == Integer.MAX_VALUE){
                    rooms[newRow][newCol] = rooms[first.row][first.col] + 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
        }
        
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