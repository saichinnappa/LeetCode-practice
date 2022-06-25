class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        
        left[0] = 1;
        
        for(int i = 1; i < length ; i++){
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        int r = 1;
        for(int i = length - 1; i > -1; i--){
            left[i] = r * left[i];
            r *= nums[i];
        }
        
        return left;
    }
}