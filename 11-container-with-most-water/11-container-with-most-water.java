class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int max = 0;
        
        while(i < j){
            max = Math.max(max, (j - i) * Math.min(height[j], height[i]));
            if(height[j] < height[i])
                j--;
            else if(height[j] > height[i])
                i++;
            else{
                i++;
                j--;
            }
        }
        
        return max;
    }
}