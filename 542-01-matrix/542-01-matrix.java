class Solution {
    public int[][] updateMatrix(int[][] mat) {
        
        Deque<Pair> queue = new LinkedList<Pair>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 0)
                    queue.offer(new Pair(i, j));
                else
                    mat[i][j] = -1;
            }
        }
        
        
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        int m = mat.length;
        int n = mat[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        while(!queue.isEmpty()){
            
            Pair first = queue.poll();
            for(int[] d : directions){
                int newRow = first.row + d[0];
                int newCol = first.col + d[1];
                if(newRow > -1 && newCol > -1 && newRow < m && newCol < n && mat[newRow][newCol] == -1){
                    mat[newRow][newCol] = mat[first.row][first.col] + 1;
                    queue.offer(new Pair(newRow, newCol));
                }
            }
            
            
        }
        
        
        return mat;
        
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