class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int left = 0;
        int right = cols - 1;
        int up = 0;
        int down = rows - 1;
        
        
        while(result.size() < rows * cols) {
            
            //move L-> R directon
            for(int i = left; i <= right; i++){
  
                if(!visited[up][i]){
                    result.add(matrix[up][i]);
                    visited[up][i] = true;
                }
            }
            

            
            //  UP -> DOWN
            for(int i = up + 1; i <= down; i++){
                if(!visited[i][right]){
                    result.add(matrix[i][right]);
                    visited[i][right] = true;
                }
            }
            

            
            // DOWN -> LEFT
            for(int i = right - 1; i >= left; i--){
                if(!visited[down][i]){
                    result.add(matrix[down][i]);
                    visited[down][i] = true;
                }
            }
            

            
            for(int i = down - 1; i >= up; i--){
                if(!visited[i][left]){
                    result.add(matrix[i][left]);
                    visited[i][left] = true;
                }
            }
            up++;
            left++;
            right--;
            down--;
        }
        
        return result;
    }
}