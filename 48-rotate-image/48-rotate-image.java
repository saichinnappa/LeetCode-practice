class Solution {
    public void rotate(int[][] matrix) {
        int nrows = matrix.length;
        int ncols = matrix[0].length;
        boolean[][] swap = new boolean[nrows][ncols];
        
        for(int i = 0; i < nrows; i++){
            for(int j = 0; j < ncols; j++){
                if(i !=j && !swap[i][j]){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                    swap[i][j] = true;
                    swap[j][i] = true;
                }
            }
        }
        
        for(int[] row : matrix){
            int i = 0;
            int j = row.length - 1;
            while(i < j){
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }
}