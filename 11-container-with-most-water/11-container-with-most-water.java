class Solution {
    public int maxArea(int[] height) {
        // int maxArea = 0;
        // for(int i = 0; i < height.length; i++){
        //     int currArea = height[i];
        //     for(int j = i + 1; j < height.length; j++){
        //         currArea =  Math.min(height[i], height[j]) * (j - i);
        //         maxArea = Math.max(currArea, maxArea);
        //     }
        // }
        // return maxArea;
        
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        
        while(i < j){
            int area = Math.min(height[i], height[j]) * (j - i);
            maxArea = Math.max(maxArea, area);
            if(height[i] < height[j])
                i++;
            else if(height[i] > height[j])
                j--;
            else{
                i++;
                j--;
            }
        }
        
        return maxArea;
    }
}