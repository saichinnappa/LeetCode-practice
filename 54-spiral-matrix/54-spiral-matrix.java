class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        boolean[][] visited = new boolean[r][c];
        
        int up = 0;
        int right = c - 1;
        int down = r - 1;
        int left = 0;
        
        while(result.size() != r * c){
            
            //L -> R
            for(int i = left; i <= right; i++){
                if(!visited[up][i]){
                    visited[up][i] = true;
                    result.add(matrix[up][i]);
                }
            }
            
            
            
            for(int i = up + 1; i <= down; i++){
                if(!visited[i][right]){
                    visited[i][right] = true;
                    result.add(matrix[i][right]);
                }
            }
            
            
            
            for(int i = right - 1; i >= left; i--){
                if(!visited[down][i]){
                    visited[down][i] = true;
                    result.add(matrix[down][i]);
                }
            }
            
            
            
            for(int i = down ; i >= up; i--){
            System.out.println(left+" "+i);    
                if(!visited[i][left]){
                    visited[i][left] = true;
                    result.add(matrix[i][left]);
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