class Solution {
    public int maxArea(int[] height) {
     
        int maxArea = 0;
        int start = 0;
        int end = height.length - 1;
        
        while(start < end){
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));
            if(height[start] < height[end])
                start++;
            else if(height[start] > height[end])
                end--;
            else{
                start++;
                end--;
            }
        }
        
        return maxArea;
    }
}