class Solution {
    public int trap(int[] height) {
        if(height.length < 3)
            return 0;
        int n = height.length;
        int[] maxLeft = new int[n];
        maxLeft[0] = height[0];
        int[] maxRight = new int[n];
        maxRight[n - 1] =  height[n-1];
        
        for(int i = 1; i< n; i++){
            maxLeft[i] = Math.max(height[i], maxLeft[i - 1]);
        }
        
       
        
        System.out.println(Arrays.toString(maxLeft));
        
        for(int j = n - 2; j > -1; j--){
            maxRight[j] = Math.max(height[j], maxRight[j+1]);
        }
        
        System.out.println(Arrays.toString(maxRight));
        
        int result = 0;
        
        for(int i = 1; i <  height.length - 1; i++){
            result += Math.min(maxLeft[i], maxRight[i]) - height[i];
        }
        
        return result;
    }
    
}