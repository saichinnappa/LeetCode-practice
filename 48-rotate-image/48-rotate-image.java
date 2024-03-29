class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < n; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                
            }
        }
        
        // System.out.println(Arrays.deepToString(matrix));
        
        int k = n - 1;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n/2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][k - j];
                matrix[i][k - j] = temp;
            }
        }
        
    }
}