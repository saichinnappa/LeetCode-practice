class Solution {
    public int[][] generateMatrix(int n) {
        int x = 1;
        int[][] result = new int[n][n];
        
        int top = 0;
        int left = 0;
        int right = n - 1;
        int bottom = n - 1;
        
        while(top <= bottom && left <= right){
            
            //top
            for(int i = left; i <= right; i++){
                result[top][i] = x++;
            }
            top++;
            // System.out.println(Arrays.deepToString(result));
            
            //right
            for(int i = top; i <= bottom; i++){
                result[i][right] = x++;
            }
            right--;
            // System.out.println(Arrays.deepToString(result));
            
            //bottom
            for(int i = right; i >= left; i--){
                result[bottom][i] = x++;
            }
            bottom--;
             // System.out.println(Arrays.deepToString(result));
            //left
            for(int i = bottom; i >= top; i--){
                result[i][left] = x++;
            }
            left++;
            // System.out.println(Arrays.deepToString(result));
            // System.out.println(x);
            
        }
        return result;
    }
}