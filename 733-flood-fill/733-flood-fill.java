class Solution {
    int m=0, n = 0;
    int[][] image;
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        this.image = image;
        this.m = image.length;
        this.n = image[0].length;
        if(image[sr][sc] == color)
            return image;
        else{
            int oldColor = image[sr][sc];
            dfs(oldColor, m, n, sr,sc, color);
        }
        return image;
    }
    
    private void dfs(int oldColor, int m, int n, int r, int c, int newColor){
        if(r > -1 && c > -1 && r < m && c < n && image[r][c] == oldColor){
            image[r][c] = newColor;
            dfs(oldColor, m, n, r + 1, c, newColor);
            dfs(oldColor, m, n, r - 1, c, newColor);
            dfs(oldColor, m, n, r, c + 1, newColor);
            dfs(oldColor, m, n, r, c - 1, newColor);
        }else{
           return; 
        }
    }
}