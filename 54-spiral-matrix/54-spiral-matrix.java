class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        
        List<Integer> result = new ArrayList<>();
        boolean[][] visited = new boolean[r][c];
        
        int up = 0;
        int left= 0;
        int right = c -1;
        int down = r - 1;
        
        while(result.size() != r * c){
            
            for(int i = left; i <=right; i++){
                if(!visited[up][i]){
                    visited[up][i] = true;
                    result.add(matrix[up][i]);
                }
            }
            
            up++;
            
            for(int i = up; i <= down; i++){
                if(!visited[i][right]){
                    visited[i][right] = true;
                    result.add(matrix[i][right]);
                }
            }
            right--;
            
            for(int i = right; i >= left; i--){
                if(!visited[down][i]){
                    visited[down][i] = true;
                    result.add(matrix[down][i]);
                }
            }
            
            down--;
            
            for(int i = down; i >= up; i--){
                if(!visited[i][left]){
                    visited[i][left] = true;
                    result.add(matrix[i][left]);
                }
            }
            left++;
        }
        return result;
    }
}