class Solution {
    int[][] directions = {{1, 0},{0, 1},{0,-1},{-1,0}, {-1,-1}, {-1, 1}, {1, -1}, {1,1}};
    int m, n;
    int[][] grid;
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid.length == 0 || grid == null)
            return -1;
        
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        
        if((m == 1 && n == 1) && grid[m -1][n - 1] == 0)
            return 1;
        
        if(grid[0][0] != 0 || grid[m - 1][n - 1] != 0)
            return -1;
        
        Deque<Pair> queue = new LinkedList<Pair>();
        queue.offer(new Pair(0, 0));
        grid[0][0] = 1;
        int distance = 0;
        while(!queue.isEmpty()){
            Pair first = queue.poll();
            distance = grid[first.row][first.col];
            if(first.row == m - 1 && first.col == n -1)
                return distance;
            // distance++;
            List<Pair> neighbors = getNeighbors(first.row,first.col);
            for(Pair p : neighbors){
                grid[p.row][p.col]  = distance + 1;
                queue.offer(new Pair(p.row, p.col));
            }
        }
        
        return -1;
        
        
    }
    
    private List<Pair> getNeighbors(int row, int col){
        
        List<Pair> list = new ArrayList<>();
        for(int[] d : directions){
            int newRow = row + d[0];
            int newCol = col + d[1];
            if(newRow > -1 & newCol > -1 && newRow < m && newCol < n && grid[newRow][newCol]== 0){
                list.add(new Pair(newRow, newCol));
            }
        }
        return list;
        
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
