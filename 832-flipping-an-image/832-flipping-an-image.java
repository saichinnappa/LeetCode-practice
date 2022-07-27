class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
     
        int m = image.length - 1;
        int n = image[0].length - 1;
        
        for(int i = 0; i < image.length; i++){
            int j = 0;
            int jMax = n;

            while(j < jMax){
                int temp = image[i][j];
                image[i][j] = image[i][jMax];
                image[i][jMax] = temp;
                j++;
                jMax--;
            }
        }
        
        for(int i = 0; i <image.length; i++){
            for(int j = 0; j < image[0].length; j++){
                    image[i][j] = image[i][j] == 0 ? 1 : 0;
            }
        }
        
        return image;
    }
}