class Solution {
    public int maxProduct(int[] nums) {
        int currentMin = nums[0];
        int currentMax = nums[0];
        int result = nums[0];
        for(int i = 1;  i < nums.length; i++){
            int temp = Math.max(nums[i], Math.max(nums[i] * currentMax, nums[i] * currentMin));
            currentMin = Math.min(nums[i], Math.min(nums[i] * currentMin, nums[i] * currentMax));
            currentMax = temp;
            result = Math.max(result, currentMax);
        }
        return result;
    }
}