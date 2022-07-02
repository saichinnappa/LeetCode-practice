class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        result[0] = 1;
        for(int i = 1; i < nums.length; i++){
            result[i] = result[i - 1] * nums[i - 1] ;
        }
        
        int r = 1;
        
        for(int i = length - 1; i > -1; i--){
            result[i] = r * result[i];
            r *= nums[i];
        }
        
        return result;
    }
}