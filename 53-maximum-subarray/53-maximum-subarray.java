class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i = 0; i < nums.length; i++){
            currentSum = Math.max(currentSum + nums[i], nums[i]);
            maxValue = Math.max(maxValue, currentSum);
        }
        return maxValue;
    }
}