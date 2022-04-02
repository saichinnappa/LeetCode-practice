class Solution {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while(i < j){
            maxArea = Math.max(maxArea, (j - i) * Math.min(height[i], height[j]));
            if(height[i] > height[j])
                j--;
            else if(height[i] < height[j])
                i++;
            else{
                i++;
                j--;
            }
        }
        return maxArea;
    }
}