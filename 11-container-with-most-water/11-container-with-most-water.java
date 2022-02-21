class Solution {
    public int maxArea(int[] height) {
        
        //APPROACH 1: BRUTE FORCE -- TLE
//         int maxValue = Integer.MIN_VALUE;
//         for(int i = 0; i< height.length; i++){
//             int value = 0;
//             for(int j = i + 1; j < height.length; j++){
//                 value = Math.min(height[i], height[j]) * (j - i);
//                 maxValue = Math.max(value, maxValue);          
//             }
  
//         }
//         return maxValue;
        
        int start = 0;
        int end = height.length - 1;
        int maxValue = Integer.MIN_VALUE;
        while(start < end){
            
            int value = Math.min(height[start], height[end]) * (end - start);
            maxValue = Math.max(maxValue, value);
            
            if(height[start] < height[end]){
                start++;
            }else if(height[end] < height[start]){
                end--;
            } else{
                start++;
                end--;
            }
        }
        return maxValue;
    }
}