class Solution {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int curr = nums[0];
        int max = nums[0];
        
        for(int i = 1; i < nums.length; i++){
            int temp = curr + nums[i];
            curr = Math.max(nums[i], temp);
            max = Math.max(curr, max);
        }
        
        return max;
    }
}