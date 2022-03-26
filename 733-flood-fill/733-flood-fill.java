class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // image[sr][sc] = newColor;
        
        int toBecolored = image[sr][sc];
        if(toBecolored == newColor)
            return image;
        dfs(sr, sc, newColor, image, toBecolored);
        return image;
    }
    
    void dfs(int row, int col, int newColor, int[][] image, int toBecolored){
        if(row < image.length && row > -1 && col < image[0].length && col > -1 && image[row][col] == toBecolored){
            image[row][col] = newColor;
        } else{
            return;
        }
        dfs(row + 1, col, newColor, image, toBecolored);
        dfs(row - 1, col, newColor, image, toBecolored);
        dfs(row, col + 1, newColor, image, toBecolored);
        dfs(row, col - 1, newColor, image, toBecolored);
    }
}