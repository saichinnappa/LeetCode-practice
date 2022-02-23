class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i< matrix.length; i++){
            for(int j = i + 1; j < matrix[0].length; j++){
                if(i != j){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        
        int length = matrix[0].length - 1;
        for(int i = 0; i < matrix.length ; i++){
            for(int j = 0; j < matrix[i].length / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][length - j];
                matrix[i][length - j] = temp;
            }
        }
    }
}