class Solution {
    public int maxArea(int[] nums) {
        int i = 0;
        int j = nums.length -1;
        int result = 0;
        
        while(i < j){
                result = Math.max(result, Math.min(nums[i], nums[j]) * (j - i));
            
            if(nums[i] < nums[j]){
                i++;
            }
            else if(nums[i] > nums[j]){
                // result = Math.max(result, nums[j] * (j - i));
                j--;
            } else{
                // result = Math.max(result, nums[j] * (j - i));
               i++;
                j--;
            }
        }
        return result;
    }
}