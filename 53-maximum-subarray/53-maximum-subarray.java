class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int max = nums[0];
        int result = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            max = Math.max(nums[i] + max, nums[i]);
            result = Math.max(result, max);
        }
        
        return result;
    }
}