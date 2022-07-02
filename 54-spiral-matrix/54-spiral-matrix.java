class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int up = 0;
        int down = m - 1;
        int right = n - 1;
        int left = 0;
        
        while(result.size() != m * n){
            for(int i = left; i <= right; i++){
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