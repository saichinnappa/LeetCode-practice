class Solution {
    public void setZeroes(int[][] matrix) {
     
        Queue<int[]> queue = new LinkedList();
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            for(int i = 0; i < cols; i++){
                matrix[first[0]][i] = 0;
            }
            for(int j = 0; j < rows; j++){
                matrix[j][first[1]] = 0;
            }
        }
        
    }
}