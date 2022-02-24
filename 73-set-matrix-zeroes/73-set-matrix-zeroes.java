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
        
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> colSet = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            if(!rowSet.contains(first[0])){
                rowSet.add(first[0]);
                for(int i = 0; i < cols; i++){
                    matrix[first[0]][i] = 0;
                }
            }
            
            if(!colSet.contains(first[1])){
                for(int j = 0; j < rows; j++){
                    matrix[j][first[1]] = 0;
                }
                colSet.add(first[1]);
            }
        }
        
    }
}