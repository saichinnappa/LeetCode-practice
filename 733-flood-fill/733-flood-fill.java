class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int oldColor = image[sr][sc];
        if(oldColor != color)
        dfs(image, oldColor, color, sr, sc);
        
        return image;
    }
    
    
    void dfs(int[][] image, int oldColor, int newColor, int row, int col){
        if(row >= 0 && col >= 0 && row < image.length && col < image[0].length && image[row][col] == oldColor){
            image[row][col] = newColor;
            dfs(image, oldColor, newColor, row + 1, col);
            dfs(image, oldColor, newColor, row - 1, col);
            dfs(image, oldColor, newColor, row, col + 1);
            dfs(image, oldColor, newColor, row, col - 1);
        }
        
    }
}