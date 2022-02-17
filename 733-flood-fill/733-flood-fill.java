class Solution {
    int newColor = -1;
    int[][] image;
    int changeColor = -1;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        this.image = image;
        this.newColor = newColor;
        this.changeColor = image[sr][sc];
        
        if(changeColor == newColor)
            return image;
        
        // for(int i = 0; i < image.length; i++){
        //     for(int j = 0; j < image[0].length; j++){
        //         if(image[i])
        //     }
        // }
        
        dfs(sr, sc);
        return image;
    }
    
    
    void dfs(int sr, int sc){
        if(sr < image.length && sr > -1 && sc < image[0].length && sc > -1 && image[sr][sc] == changeColor){
            image[sr][sc] = newColor;
        } else{
            return;
        }
        
        dfs(sr + 1, sc);
        dfs(sr , sc + 1);
        dfs(sr - 1, sc);
        dfs(sr, sc -1);
        return;
    }
}