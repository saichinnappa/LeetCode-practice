class Solution {
    public void setZeroes(int[][] matrix) {
        Deque<int[]> queue = new LinkedList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0;  j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        Set<Integer> rSet = new HashSet<>();
        Set<Integer> cSet = new HashSet<>();
        
        while(!queue.isEmpty()){
            int[] first = queue.poll();
            int row = first[0];
            int col = first[1];
            
            if(!rSet.contains(row)){
                rSet.add(row);
                for(int i = 0; i< matrix[0].length; i++){
                    matrix[row][i] = 0;
                }
            }
            
            if(!cSet.contains(col)){
                cSet.add(col);
                for(int i = 0; i < matrix.length; i++){
                    matrix[i][col] = 0;
                }
            }
            
        }
    }
}