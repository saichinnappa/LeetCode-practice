class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int result = max;
        
        for(int i = 1;  i < nums.length; i++){
            int tempMax = Math.max(nums[i], Math.max( nums[i] * min, nums[i] * max));
            min = Math.min(nums[i], Math.min(nums[i] * min, nums[i] * max));
            max = tempMax;
            result = Math.max(result, max);
        }
        return result;
    }
}