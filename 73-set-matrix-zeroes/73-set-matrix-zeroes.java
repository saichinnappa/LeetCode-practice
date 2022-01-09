class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> list = new ArrayList();
        for(int i = 0; i< matrix.length; i++){
            for(int j = 0; j< matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    list.add(new int[]{i, j});
                }
            }
        }
        
        if(list.size() == 0) return;
        
        for(int i = 0; i < list.size(); i++){
            int row = list.get(i)[0];
            int col = list.get(i)[1];
            int x = 0;
            while(x != matrix[row].length){
                matrix[row][x] = 0;
                x++;
            }
            int y = 0;
            while(y != matrix.length){
                matrix[y][col] = 0;
                y++;
            }
        }
    }
}