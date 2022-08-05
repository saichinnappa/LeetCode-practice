class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;
        
        for(int i = 1; i < nums.length; i++){
            result[i] = nums[i - 1] * result[i - 1];
        }
        
        int r = 1;
        
        for(int i = n - 1; i > -1; i--){
            result[i] *= r;
            r *= nums[i];
        }
        
        return result;
        
    }
}