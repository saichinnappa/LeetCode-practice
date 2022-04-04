class Solution {
    public void rotate(int[][] matrix) {
        boolean[][] track = new boolean[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(i != j && !track[i][j]){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    track[i][j] = true;
                    track[j][i] = true;
                }
            }
        }
        int n = matrix[0].length - 1;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix.length / 2 ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j];
                matrix[i][n - j] = temp;
            }
        }
    }
}