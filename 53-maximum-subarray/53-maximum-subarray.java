class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int maxElement = nums[0];
        int result = nums[0];
        int currentSum = nums[0];
        for(int i = 1; i < nums.length; i++){
            currentSum = Math.max( currentSum + nums[i], nums[i]);
            result = Math.max(currentSum, result);
        }
        
        return result;
    }
}