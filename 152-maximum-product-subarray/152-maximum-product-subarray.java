class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int currentMin = nums[0];
        int currentMax = nums[0];
        
        for(int j=1; j< nums.length; j++){
            int i = nums[j];
            int temp = Math.max(i, Math.max(i * currentMax, i * currentMin));
            currentMin = Math.min(i, Math.min(i * currentMax, i * currentMin));
            currentMax = temp;
            result = Math.max(result, currentMax);
        }
        
        return result;
    }
}